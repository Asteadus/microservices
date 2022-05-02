package be.technifutur.products.data.repositories;

import be.technifutur.products.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
}
