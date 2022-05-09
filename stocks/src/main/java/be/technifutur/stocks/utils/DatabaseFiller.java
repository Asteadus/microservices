package be.technifutur.stocks.utils;

import be.technifutur.stocks.model.entity.Stock;
import be.technifutur.stocks.repository.StockRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class DatabaseFiller implements InitializingBean {

    private final StockRepository stockRepository;

    @Override
    public void afterPropertiesSet() throws Exception {

        // region PRODUCT
        Stock p0 = Stock.builder()
                .productReference(UUID.randomUUID())
                .quantity(5)
                .build();
        stockRepository.save(p0);
        System.out.println(p0.getProductReference());

        Stock p1 = Stock.builder()
                .productReference(UUID.randomUUID())
                .quantity(12)
                .build();
        stockRepository.save(p1);

        Stock p2 = Stock.builder()
                .productReference(UUID.randomUUID())
                .quantity(142)
                .build();
        stockRepository.save(p2);

        Stock p3 = Stock.builder()
                .productReference(UUID.randomUUID())
                .quantity(0)
                .build();
        stockRepository.save(p3);
        // endregion

    }
}
