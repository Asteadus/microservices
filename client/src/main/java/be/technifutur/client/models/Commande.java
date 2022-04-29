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
@Table(name = "commande")
public class Commande {
    @Id
    @Column(name = "idcommande", nullable = false)
    private Long idCommande;
    @Column(name = "ref_commande", nullable = false, length = 45)
    private Long refCommande;
}
