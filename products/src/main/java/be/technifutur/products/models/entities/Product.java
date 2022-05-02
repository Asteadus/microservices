package be.technifutur.products.models.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Table @Entity
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, updatable = false)
    private UUID uuid;

    @Column(length = 45)
    @NotBlank
    private String name;

    private boolean onSale;

    @NotNull
    @Min(0)
    private float sellingPrice;

    @Min(0)
    private float buyingPrice;


    @ManyToOne
    @JoinColumn()
    private Category category;

    @ManyToOne
//    @JoinColumn(nullable = false)
    private Brand brand;

}
