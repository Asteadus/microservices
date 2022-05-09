package be.technifutur.stocks.repository;

import be.technifutur.stocks.model.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface StockRepository extends JpaRepository<Stock, Long> {

    Optional<Stock> findByProductReference(UUID reference);

}
