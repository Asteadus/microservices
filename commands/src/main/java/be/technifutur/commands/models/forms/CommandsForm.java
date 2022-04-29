package be.technifutur.commands.models.forms;

import be.technifutur.commands.models.entities.Clients;
import be.technifutur.commands.models.entities.ProductOrders;
import lombok.Data;
import org.apache.tomcat.jni.Local;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Data
@Validated
public class CommandsForm {


    private Set<ProductOrders> productOrders;
    private Long clientID;
    private LocalDate date;
}
