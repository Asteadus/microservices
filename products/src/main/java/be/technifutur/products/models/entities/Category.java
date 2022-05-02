package be.technifutur.products.models.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true, length = 45)
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> productsList;







}
