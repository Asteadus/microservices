package be.technifutur.commands.models.entities;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "commands")
public class Commands {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commands_id", nullable = false)
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name="ref_commands", nullable = false, unique = true)
    private UUID refCommands ;



    @OneToMany(mappedBy = "commands")
    Set<ProductOrders> productOrders;


    @ManyToOne
    @JoinColumn(name = "clients_id")
    Clients clients;


}
