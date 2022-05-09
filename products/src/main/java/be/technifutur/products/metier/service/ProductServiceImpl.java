package be.technifutur.products.metier.service;

import be.technifutur.products.data.repositories.ProductRepository;
import be.technifutur.products.exceptions.ElementNotFoundException;
import be.technifutur.products.metier.mapper.ProductMapper;
import be.technifutur.products.models.dto.ProductDTO;
import be.technifutur.products.models.entities.Product;
import be.technifutur.products.models.form.ProductForm;
import be.technifutur.products.rabbit.MessageSender;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductMapper mapper;
    private final ProductRepository repo;
    private final MessageSender sender;
    private final ObjectMapper objectMapper;

    public ProductServiceImpl(ProductMapper mapper, ProductRepository repo, MessageSender sender, ObjectMapper objectMapper) {
        this.mapper = mapper;
        this.repo = repo;
        this.sender = sender;
        this.objectMapper = objectMapper;
    }

    @Override
    public ProductDTO getProductByID(Long id) {
        return repo.findById(id).filter(Product::isOnSale).map(mapper:: entityToDTO ).orElseThrow(() -> new ElementNotFoundException(id, Product.class));
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return repo.findAll().stream().filter(Product::isOnSale).map(mapper :: entityToDTO).toList();
    }

    @Override
    public ProductDTO addProduct(ProductForm form) throws JsonProcessingException {
        Product p = mapper.formToEntity(form);
        p = repo.save(p);
        ProductDTO pDto = mapper.entityToDTO(p) ;
        sender.productSender(objectMapper.writeValueAsString(pDto));
        return pDto;
    }

    @Override
    public ProductDTO updateProductByID(Long id, ProductForm form) {
        boolean exist = repo.existsById(id);
        if(exist){
            Product entity= mapper.formToEntity(form);
            entity.setId(id);
            entity = repo.save(entity);

            return mapper.entityToDTO(entity);
        }else{
            return null;
        }

    }

    //Ne supprime pas le produit mais passe le booléen "on_sale" à false, il n'apparait donc plus dans le getOne et getAll
    @Override
    public ProductDTO deleteProductByID(Long id) {
        Product entity =  repo.findById(id).orElseThrow(() -> new ElementNotFoundException(id, Product.class));
        entity.setOnSale(false);
        repo.save(entity);

        return mapper.entityToDTO(entity);



    }
}
