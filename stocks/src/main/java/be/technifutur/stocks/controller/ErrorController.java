package be.technifutur.stocks.controller;

import be.technifutur.stocks.exception.ElementNotFoundException;
import be.technifutur.stocks.model.dto.ErrorDTO;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

public class ErrorController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleElementNotFound(ElementNotFoundException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(
                        ErrorDTO.builder()
                                .message(e.getMessage())
                                .method(HttpMethod.resolve(request.getMethod()))
                                .status(404)
                                .uri(request.getRequestURI())
                                .build()
                );
    }

}
