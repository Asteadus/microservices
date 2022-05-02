package be.technifutur.stocks.utils;

import be.technifutur.stocks.model.entity.Product;
import be.technifutur.stocks.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class DatabaseFiller implements InitializingBean {

    private final ProductRepository productRepository;

    @Override
    public void afterPropertiesSet() throws Exception {

        // region PRODUCT
        Product p0 = Product.builder()
                .reference(UUID.randomUUID())
                .quantity(5)
                .build();
        productRepository.save(p0);
        System.out.println(p0.getReference());

        Product p1 = Product.builder()
                .reference(UUID.randomUUID())
                .quantity(12)
                .build();
        productRepository.save(p1);

        Product p2 = Product.builder()
                .reference(UUID.randomUUID())
                .quantity(142)
                .build();
        productRepository.save(p2);

        Product p3 = Product.builder()
                .reference(UUID.randomUUID())
                .quantity(0)
                .build();
        productRepository.save(p3);
        // endregion

    }
}
