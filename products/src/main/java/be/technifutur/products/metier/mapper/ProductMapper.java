package be.technifutur.products.metier.mapper;

import be.technifutur.products.models.dto.ProductDTO;
import be.technifutur.products.models.entities.Product;
import be.technifutur.products.models.form.ProductForm;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductMapper {

    public ProductDTO entityToDTO(Product entity){
        if(entity == null)
            return null;

        ProductDTO.BrandDTO brandDTO = entity.getBrand() == null? null : new ProductDTO.BrandDTO(entity.getBrand().getId(), entity.getBrand().getName());

        ProductDTO.CategoryDTO categoryDTO = entity.getCategory() == null? null : new ProductDTO.CategoryDTO(entity.getCategory().getId(), entity.getCategory().getName());

        return ProductDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .brand(brandDTO)
                .category(categoryDTO)
                .buyingPrice(entity.getBuyingPrice())
                .sellingPrice(entity.getSellingPrice())
                .uuid(entity.getUuid())
                .build();
    }

    public Product formToEntity(ProductForm form) {
        if(form == null)
            return null;
        return Product.builder()
                .name(form.getName())
                .onSale(true)
                .buyingPrice(form.getBuyingPrice())
                .sellingPrice(form.getSellingPrice())
                .uuid(UUID.randomUUID())
                .build();

    }
}
