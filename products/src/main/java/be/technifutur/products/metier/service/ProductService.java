package be.technifutur.products.metier.service;

import be.technifutur.products.models.dto.ProductDTO;
import be.technifutur.products.models.form.ProductForm;

import java.util.List;

public interface ProductService {

    public ProductDTO getProductByID (Long id);

    public List<ProductDTO> getAllProducts();

    public ProductDTO addProduct (ProductForm form);

    public ProductDTO updateProductByID(Long id, ProductForm form);

    public ProductDTO deleteProductByID(Long id);

}
