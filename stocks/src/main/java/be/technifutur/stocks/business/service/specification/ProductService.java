package be.technifutur.stocks.business.service.specification;

import be.technifutur.stocks.model.dto.ProductDTO;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    // CREATE
    ProductDTO addStockToProduct(UUID reference, int quantity);

    // READ
    List<ProductDTO> getAllProducts();
    ProductDTO getProductByStockId(Long id);
    ProductDTO getProductByRef(UUID ref);

    // UPDATE
    ProductDTO updateProductQuantityByStockId(Long id, int quantity);
}
