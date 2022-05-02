package be.technifutur.products.models.form;

import be.technifutur.products.models.entities.Brand;
import be.technifutur.products.models.entities.Category;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Validated @Data
public class ProductForm {


    @NotBlank
    @Length(max = 45)
    private String name;

    private boolean onSale;

    @Positive @NotNull
    private float sellingPrice;

    @Positive
    private float buyingPrice;

    private Category category;

//    @NotNull
    private Brand brand;

}
