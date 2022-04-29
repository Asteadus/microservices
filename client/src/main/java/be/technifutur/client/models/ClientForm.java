package be.technifutur.client.models;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class ClientForm {
    private Long idClient;
    @NotBlank(message="Le nom du client ne peut être vide et ne pas doit dépasser 45 caractères !")
    @Size(min=1, max=45)
    private String nomClient;
    @NotBlank(message="Le prénom du client ne peut être vide et ne pas doit dépasser 45 caractères !")
    @Size(min=1, max=45)
    private String prenomClient;
    @NotBlank(message="La rue du client ne peut être vide et ne pas doit dépasser 45 caractères !")
    @Size(min=1, max=45)
    private String rueClient;
    @NotBlank(message="Le numero du client ne peut être vide et ne pas doit dépasser 45 caractères !")
    @Size(min=1, max=45)
    private String numeroClient;
    @NotBlank(message="Le code postal du client ne peut être vide et ne pas doit dépasser 45 caractères !")
    @Size(min=1, max=45)
    private String cpClient;
    @NotBlank(message="Le mail du client ne peut être vide et ne pas doit dépasser 200 caractères !")
    @Size(min=1, max=200)
    private String mailClient;
    @NotBlank(message="La date de naissance du client ne peut être vide !")
    private LocalDate dateNaissanceClient;
    @NotBlank(message="Le pays du client ne peut être vide et ne pas doit dépasser 45 caractères !")
    @Size(min=1, max=45)
    private String paysClient;
//    @NotBlank(message="Le nom du client ne peut être vide et ne pas doit dépasser 45 caractères !")
    private Integer actifClient;
    @NotBlank(message="Le numero du client ne peut être vide et ne pas doit dépasser 45 caractères !")
    @Size(min=1, max=45)
    private String numTVAClient;
}
