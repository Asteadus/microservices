package be.technifutur.stocks.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class InvalidQuantityException extends RuntimeException {

    private final Object reference;
    private final int quantity;
    private final Class<?> c;

    public InvalidQuantityException(Object reference, int quantity, Class<?> c) {
        super("Quantity {" + quantity + "} for element ref. {" + reference + "}.");
        this.reference = reference;
        this.quantity = quantity;
        this.c = c;
    }

    public Object getReference() {
        return reference;
    }

    public int getQuantity() { return quantity; }

    public Class<?> getC() { return c; }

}
