package be.technifutur.stocks.business.mapper;

import be.technifutur.stocks.model.dto.ProductDTO;
import be.technifutur.stocks.model.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    public ProductDTO entityToDTO(Product entity) {
        if (entity == null) {
            return null;
        }

        return ProductDTO.builder()
                .stockId(entity.getStockId())
                .reference(entity.getReference())
                .quantity(entity.getQuantity())
                .build();
    }

}
