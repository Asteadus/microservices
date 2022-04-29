package be.technifutur.commands.models.entities;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "productorders")
public class ProductOrders {


    @EmbeddedId
    ProductOrdersKey id;

    @Column(name = "quantite")
    private Integer quantite;


    @ManyToOne
    @MapsId("commandsId")
    @JoinColumn(name = "commands_id")
    Commands commands;

    @ManyToOne
    @MapsId("productsId")
    @JoinColumn(name = "products_id")
    Products products;
}
