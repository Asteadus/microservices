package be.technifutur.commands.models.dtos;

import be.technifutur.commands.models.entities.Commands;
import be.technifutur.commands.models.entities.ProductOrders;
import be.technifutur.commands.models.entities.Products;
import be.technifutur.commands.models.entities.Clients;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CommandsDTO implements Serializable {
    private final Long id;
    private final UUID refCommands;
    private final LocalDate date;
    private final Set<ProductOrdersDTO> productOrders;
    private final ClientDTO client;

    public static CommandsDTO of (Commands commands){
        if (commands == null)
            return null;
        return new CommandsDTO(
                commands.getId(),
                commands.getRefCommands(),
                commands.getDate(),
                commands.getProductOrders() == null ? null : commands.getProductOrders().stream().map(ProductOrdersDTO::of).collect(Collectors.toSet()),
                ClientDTO.of(commands.getClients())


        );
    }

    @Data
    public static class ProductOrdersDTO{
        private final Integer quantite;
        private final ProductDTO product;

        public static ProductOrdersDTO of(ProductOrders productOrders){
            if(productOrders == null)
                return null;
            return new ProductOrdersDTO(
                    productOrders.getQuantite(),
                    ProductDTO.of(productOrders.getProducts())
            );
        }

    }
    @Data
    public static class ClientDTO{
        private final Long id;
        private final UUID refClient;
        private final String nom;

        public static ClientDTO of(Clients client){
            if(client == null)
                return null;
            return new ClientDTO(
                    client.getId(),
                    client.getRefClient(),
                    client.getNom()
            );
        }
    }
    @Data
    public static class ProductDTO{
        private final Long id;
        private final UUID refProduit;
        private final String nom;

        public static ProductDTO of(Products product){
            if(product == null)
                return null;
            return new ProductDTO(
                    product.getId(),
                    product.getRefProduit(),
                    product.getNom()
            );
        }

    }

}
