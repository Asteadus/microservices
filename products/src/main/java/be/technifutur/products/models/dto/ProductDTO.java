package be.technifutur.products.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.UUID;

@Data @AllArgsConstructor @Builder
public class ProductDTO {

    private Long id;
    private UUID uuid;
    private String name;
    private float sellingPrice;
    private float buyingPrice;
    private CategoryDTO category;
    private BrandDTO brand;


    @Data @AllArgsConstructor
    public static class CategoryDTO {
        private Long id;
        private String Name;
    }

    @Data @AllArgsConstructor
    public static class BrandDTO {
        private Long id;
        private String name;
    }
}
