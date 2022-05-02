package be.technifutur.client.models;

import lombok.*;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class ClientDto {
    private Long idClient;
    private String nomClient;
    private String prenomClient;
    private String rueClient;
    private String numeroClient;
    private String cpClient;
    private String mailClient;
    private LocalDate dateNaissanceClient;
    private String paysClient;
    private Integer actifClient;
    private String numTVAClient;
    private UUID refClient;
}
