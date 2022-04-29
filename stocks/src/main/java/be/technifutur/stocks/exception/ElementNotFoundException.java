package be.technifutur.stocks.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ElementNotFoundException extends RuntimeException {

    private final Object reference;
    private final Class<?> c;

    public ElementNotFoundException(Object reference, Class<?> c) {
        super("Element ref. {" + reference + "} not found.");
        this.reference = reference;
        this.c = c;
    }

    public Object getReference() {
        return reference;
    }

    public Class<?> getC() {
        return c;
    }

}
