package be.technifutur.stocks.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ProductDTO {

    private Long stockId;
    private UUID reference;
    private int quantity;

}
