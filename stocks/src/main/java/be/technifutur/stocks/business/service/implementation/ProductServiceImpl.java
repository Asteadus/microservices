package be.technifutur.stocks.business.service.implementation;

import be.technifutur.stocks.business.mapper.ProductMapper;
import be.technifutur.stocks.business.service.specification.ProductService;
import be.technifutur.stocks.exception.ElementNotFoundException;
import be.technifutur.stocks.model.dto.ProductDTO;
import be.technifutur.stocks.model.entity.Product;
import be.technifutur.stocks.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    @Override
    public ProductDTO addStockToProduct(UUID reference, int quantity) {
        return null;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return this.repository.findAll()
                .stream()
                .map(mapper::entityToDTO)
                .toList();
    }

    @Override
    public ProductDTO getProductByStockId(Long id) {
        return this.repository.findById(id)
                .map(mapper::entityToDTO)
                .orElseThrow(() -> new ElementNotFoundException(id, ProductDTO.class));
    }

    @Override
    public ProductDTO getProductByRef(UUID ref) {
        return this.repository.findByReference(ref)
                .map(mapper::entityToDTO)
                .orElseThrow(() -> new ElementNotFoundException(ref, ProductDTO.class));
    }
}
