package be.technifutur.products.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data @AllArgsConstructor @Builder
public class BrandDTO {

    private Long id;
    private String name;
    private List<ProductDTO> productsDTOList;


    @Data @AllArgsConstructor
    public static class ProductDTO{
        private Long id;
        private String name;
    }

}
