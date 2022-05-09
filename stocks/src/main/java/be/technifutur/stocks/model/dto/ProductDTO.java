package be.technifutur.stocks.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class ProductDTO {

    private Long id;
    private UUID uuid;
    private String name;
    private float sellingPrice;
    private float buyingPrice;
    private CategoryDTO category;
    private BrandDTO brand;


    @Data
    @AllArgsConstructor
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
