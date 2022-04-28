package be.technifutur.client.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
@Table(name = "produit")
public class Produit {
    @Id
    @Column(name = "idproduit", nullable = false)
    private Long idProduit;
    @Column(name = "produit_ref", nullable = false, length = 45)
    private Long refProduit;
}
