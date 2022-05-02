package be.technifutur.commands.utils;

import be.technifutur.commands.data.repo.ClientRepository;
import be.technifutur.commands.data.repo.CommandsRepository;
import be.technifutur.commands.data.repo.ProductOrdersRepository;
import be.technifutur.commands.data.repo.ProductsRepository;
import be.technifutur.commands.models.entities.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.UUID;


@Component
public class DatabaseFiller implements InitializingBean {

    @Autowired
    private CommandsRepository commandsRepo;

    @Autowired
    private ClientRepository clientRepo;

    @Autowired
    private ProductsRepository productsRepo;

    @Autowired
    private ProductOrdersRepository productOrdersRepo;

    @Override
    public void afterPropertiesSet() throws Exception {
        commandsRepo.deleteAll();
        productsRepo.deleteAll();
        clientRepo.deleteAll();
        productOrdersRepo.deleteAll();

        Clients clients = Clients.builder()
                .nom("toto")
                .refClient(UUID.randomUUID())
                .build();

        Products products = Products.builder()
                .nom("test")
                .refProduit(UUID.randomUUID())
                .build();
        productsRepo.save(products);

        Commands commands =  Commands.builder()
                .date(LocalDate.of(2022, Month.APRIL, 29))
                .refCommands(UUID.randomUUID())
                .build();
        commandsRepo.save(commands);

        ProductOrders productOrders = ProductOrders.builder()
                .id(new ProductOrdersKey())
                .products(products)
                .quantite(4)
                .commands(commands)
                .build();
        productOrdersRepo.save(productOrders);

    }
}
