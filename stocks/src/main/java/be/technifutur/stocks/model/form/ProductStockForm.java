package be.technifutur.stocks.model.form;

import lombok.Data;

import javax.validation.constraints.PositiveOrZero;

@Data
public class ProductStockForm {

    @PositiveOrZero(message = "Quantity must be equal to or higher than zero")
    private int quantity;

}
