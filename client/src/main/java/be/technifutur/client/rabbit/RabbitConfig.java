package be.technifutur.client.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean("client_queue")
    public Queue clientQueue(){
        return new Queue("client_queue", true);
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("microservice.direct");
    }

    @Bean
    public Binding clientBinding(DirectExchange exchange, @Qualifier("client_queue") Queue queue){
        return BindingBuilder.bind(queue).to(exchange).with("client");
    }
}
