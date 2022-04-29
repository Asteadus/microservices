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
@Table(name = "favoris")
public class Favoris {
    @Id
    @Column(name = "idfavoris", nullable = false)
    private Long idFavori;
}
