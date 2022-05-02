package be.technifutur.commands.data.repo;

import be.technifutur.commands.models.entities.Commands;
import be.technifutur.commands.models.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products, Long> {
}
