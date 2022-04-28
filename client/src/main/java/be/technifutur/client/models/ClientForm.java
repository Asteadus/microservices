package be.technifutur.client.models;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class ClientForm {
    private Long idClient;
    @NotBlank(message="Le nom de l'auteur ne peut être vide et doit avoir moins de 200 caractères !")
    @Size(min=1, max=200)
    private Long nomClient;
    @NotBlank(message="Le nom de l'auteur ne peut être vide et doit avoir moins de 200 caractères !")
    @Size(min=1, max=200)
    private Long prenomClient;
    @NotBlank(message="Le nom de l'auteur ne peut être vide et doit avoir moins de 200 caractères !")
    @Size(min=1, max=200)
    private Long rueClient;
    @NotBlank(message="Le nom de l'auteur ne peut être vide et doit avoir moins de 200 caractères !")
    @Size(min=1, max=200)
    private Long numeroClient;
    @NotBlank(message="Le nom de l'auteur ne peut être vide et doit avoir moins de 200 caractères !")
    @Size(min=1, max=200)
    private Long cpClient;
    @NotBlank(message="Le nom de l'auteur ne peut être vide et doit avoir moins de 200 caractères !")
    @Size(min=1, max=200)
    private Long mailClient;
    @NotBlank(message="Le nom de l'auteur ne peut être vide et doit avoir moins de 200 caractères !")
    @Size(min=1, max=200)
    private Long paysClient;
    @NotBlank(message="Le nom de l'auteur ne peut être vide et doit avoir moins de 200 caractères !")
    @Size(min=1, max=200)
    private Integer actifClient;
    @NotBlank(message="Le nom de l'auteur ne peut être vide et doit avoir moins de 200 caractères !")
    @Size(min=1, max=200)
    private Long numTVAClient;
}
