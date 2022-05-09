package be.technifutur.stocks.business.mapper;

import be.technifutur.stocks.model.dto.StockDTO;
import be.technifutur.stocks.model.entity.Stock;
import org.springframework.stereotype.Service;

@Service
public class StockMapper {

    public StockDTO entityToDTO(Stock entity) {
        if (entity == null) {
            return null;
        }

        return StockDTO.builder()
                .stockId(entity.getStockId())
                .productReference(entity.getProductReference())
                .quantity(entity.getQuantity())
                .build();
    }

}
