package be.technifutur.stocks.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class StockDTO {

    private Long stockId;
    private UUID productReference;
    private int quantity;

}
