package be.technifutur.stocks.rabbit;

import be.technifutur.stocks.business.service.specification.StockService;
import be.technifutur.stocks.model.dto.ProductDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MessageReceiver {

    private final Logger logger = LoggerFactory.getLogger(MessageReceiver.class);
    private final StockService service;
    private final ObjectMapper mapper;

    public MessageReceiver(StockService service, ObjectMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @RabbitListener(queues = "product_queue")
    public void receive(String message) throws JsonProcessingException {
        ProductDTO product = mapper.readValue(message, ProductDTO.class);
        logger.info("PRODUCT RECEIVED - " + product);
        this.service.addStockToProduct(product.getUuid(), new Random().nextInt(1000));
    }
}