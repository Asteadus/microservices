package be.technifutur.stocks.business.service.implementation;

import be.technifutur.stocks.business.mapper.StockMapper;
import be.technifutur.stocks.business.service.specification.StockService;
import be.technifutur.stocks.exception.ElementNotFoundException;
import be.technifutur.stocks.model.dto.StockDTO;
import be.technifutur.stocks.model.entity.Stock;
import be.technifutur.stocks.repository.StockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class StockServiceImpl implements StockService {

    private final StockRepository repository;
    private final StockMapper mapper;

    // CREATE
    @Override
    public StockDTO addStockToProduct(UUID productReference, int newQuantity) {
        Stock newStockForProduct = Stock.builder()
                .productReference(productReference)
                .quantity(newQuantity)
                .build();
        newStockForProduct = this.repository.save(newStockForProduct);
        return this.mapper.entityToDTO(newStockForProduct);
    }

    // READ ALL
    @Override
    public List<StockDTO> getAllProducts() {
        return this.repository.findAll()
                .stream()
                .map(mapper::entityToDTO)
                .toList();
    }

    // READ ONE BY STOCK ID
    @Override
    public StockDTO getProductByStockId(Long id) {
        return this.repository.findById(id)
                .map(mapper::entityToDTO)
                .orElseThrow(() -> new ElementNotFoundException(id, StockDTO.class));
    }

    // READ ONE BY PRODUCT REFERENCE
    @Override
    public StockDTO getProductByRef(UUID ref) {
        return this.repository.findByProductReference(ref)
                .map(mapper::entityToDTO)
                .orElseThrow(() -> new ElementNotFoundException(ref, StockDTO.class));
    }

    // UPDATE
    @Override
    public StockDTO updateProductQuantityByStockId(Long id, int updatedQuantity) {
        Stock entity = this.repository
                .findById(id)
                .orElseThrow(() -> new ElementNotFoundException(id, StockDTO.class));
        entity.setQuantity(updatedQuantity);
        entity = repository.save(entity);
        return mapper.entityToDTO(entity);
    }
}
