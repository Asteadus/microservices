package be.technifutur.products.data.repositories;

import be.technifutur.products.models.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
