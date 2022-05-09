package be.technifutur.stocks.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean("product_queue")
    public Queue productQueue(){
        return new Queue("product_queue", true);
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("microservice.direct");
    }

    @Bean
    public Binding productBinding(DirectExchange exchange, @Qualifier("product_queue") Queue queue){
        return BindingBuilder.bind(queue).to(exchange).with("product");
    }

}