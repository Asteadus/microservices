package be.technifutur.client.models;

import lombok.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

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
    private String nomClient;
    @Column(name = "prenom", nullable = false, length = 45)
    private String prenomClient;
    @Column(name = "rue", nullable = false, length = 45)
    private String rueClient;
    @Column(name = "numero", nullable = false, length = 45)
    private String numeroClient;
    @Column(name = "cp", nullable = false, length = 45)
    private String cpClient;
    @Column(name = "adresse_mail", nullable = false, length = 200)
    private String mailClient;
    @Column(name = "date_naissance", nullable = false)
    private LocalDate dateNaissanceClient;
    @Column(name = "pays", nullable = false, length = 45)
    private String paysClient;
    @Column(name = "actif", nullable = false)
    private Integer actifClient;
    @Column(name = "num_tva", nullable = false, length = 45)
    private String numTVAClient;
    @Column(name = "refclient", nullable = false)
    private UUID refClient;
}
