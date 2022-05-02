package be.technifutur.products.utils;

import be.technifutur.products.data.repositories.BrandRepository;
import be.technifutur.products.data.repositories.CategoryRepository;
import be.technifutur.products.data.repositories.ProductRepository;
import be.technifutur.products.models.entities.Brand;
import be.technifutur.products.models.entities.Category;
import be.technifutur.products.models.entities.Product;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DataBaseFiller implements InitializingBean {

    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;

    public DataBaseFiller(ProductRepository productRepository, BrandRepository brandRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.brandRepository = brandRepository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void afterPropertiesSet() throws Exception {

        Brand brand = Brand.builder()
                .name("Dell")
                .build();
        brandRepository.save(brand);

        Category category = Category.builder()
                .name("Informatique")
                .build();
        categoryRepository.save(category);

        Product product = Product.builder()
                .name("XPS")
                .buyingPrice(650)
                .sellingPrice(850)
                .onSale(true)
                .brand(brand)
                .category(category)
                .uuid(UUID.randomUUID())
                .build();

        productRepository.save(product);

        product = Product.builder()
                .name("Inspiron")
                .buyingPrice(650)
                .sellingPrice(850)
                .onSale(true)
                .brand(brand)
                .uuid(UUID.randomUUID())
                .build();

        productRepository.save(product);

    }
}
