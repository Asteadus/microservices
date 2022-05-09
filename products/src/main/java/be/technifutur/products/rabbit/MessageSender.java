package be.technifutur.products.rabbit;

import be.technifutur.products.models.dto.ProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class MessageSender implements InitializingBean {

    private final RabbitTemplate template;


    public MessageSender(RabbitTemplate template) {
        this.template = template;
    }

    public void productSender(String Json){
        template.convertAndSend("microservice.direct","product",Json);
    }


    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
