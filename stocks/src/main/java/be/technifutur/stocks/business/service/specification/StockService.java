package be.technifutur.stocks.business.service.specification;

import be.technifutur.stocks.model.dto.StockDTO;

import java.util.List;
import java.util.UUID;

public interface StockService {

    // CREATE
    StockDTO addStockToProduct(UUID reference, int quantity);

    // READ
    List<StockDTO> getAllProducts();
    StockDTO getProductByStockId(Long id);
    StockDTO getProductByRef(UUID ref);

    // UPDATE
    StockDTO updateProductQuantityByStockId(Long id, int quantity);
}
