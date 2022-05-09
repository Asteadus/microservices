package be.technifutur.products.utils;

import be.technifutur.products.data.repositories.BrandRepository;
import be.technifutur.products.data.repositories.CategoryRepository;
import be.technifutur.products.data.repositories.ProductRepository;
import be.technifutur.products.metier.service.ProductService;
import be.technifutur.products.models.entities.Brand;
import be.technifutur.products.models.entities.Category;
import be.technifutur.products.models.entities.Product;
import be.technifutur.products.models.form.ProductForm;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DataBaseFiller implements InitializingBean {

    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;
    private final ProductService service;

    public DataBaseFiller(ProductRepository productRepository, BrandRepository brandRepository, CategoryRepository categoryRepository, ProductService service) {
        this.productRepository = productRepository;
        this.brandRepository = brandRepository;
        this.categoryRepository = categoryRepository;
        this.service = service;
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

        ProductForm productform = ProductForm.builder()
                .name("test")
                .buyingPrice(650)
                .sellingPrice(850)
                .onSale(true)
                .brand(brand)
                .category(category)
                .build();

        service.addProduct(productform);

        productform = ProductForm.builder()
                .name("test2")
                .buyingPrice(650)
                .sellingPrice(850)
                .onSale(true)
                .brand(brand)
                .category(category)
                .build();

        service.addProduct(productform);

        productform = ProductForm.builder()
                .name("test3")
                .buyingPrice(650)
                .sellingPrice(850)
                .onSale(true)
                .brand(brand)
                .category(category)
                .build();

        service.addProduct(productform);

    }
}
