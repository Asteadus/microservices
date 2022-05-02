package be.technifutur.commands.data.repo;

import be.technifutur.commands.models.entities.Commands;
import be.technifutur.commands.models.entities.ProductOrders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOrdersRepository extends JpaRepository<ProductOrders, Long> {
}
