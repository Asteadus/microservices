package be.technifutur.client.models;

import lombok.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
@Table(name = "client")
public class Client {
    @Id
    @Column(name = "idclient", nullable = false)
    private Long idClient;
    @Column(name = "nom", nullable = false, length = 45)
    private Long nomClient;
    @Column(name = "prenom", nullable = false, length = 45)
    private Long prenomClient;
    @Column(name = "rue", nullable = false, length = 45)
    private Long rueClient;
    @Column(name = "numero", nullable = false, length = 45)
    private Long numeroClient;
    @Column(name = "cp", nullable = false, length = 45)
    private Long cpClient;
    @Column(name = "adresse_mail", nullable = false, length = 200)
    private Long mailClient;
    @Column(name = "date_naissance", nullable = false)
    private LocalDate dateNaissanceClient;
    @Column(name = "pays", nullable = false, length = 45)
    private Long paysClient;
    @Column(name = "actif", nullable = false)
    private Integer actifClient;
    @Column(name = "num_tva", nullable = false, length = 45)
    private Long numTVAClient;
}
