package be.technifutur.client.utils;

import be.technifutur.client.models.Client;
import be.technifutur.client.repositories.ClientRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;

@Component
public class DatabaseFiller  implements InitializingBean {
    private final ClientRepository cRepo;

    public DatabaseFiller(ClientRepository cRepo) {
        this.cRepo = cRepo;
    }

    private void setupClient() throws ParseException {
        Client c = Client.builder()
                .idClient(1L)
                .nomClient("Balladur")
                .prenomClient("Edouard")
                .rueClient("Rue de l'Elysée")
                .numeroClient("10")
                .cpClient("56922")
                .mailClient("ed.balladur@rpr.fr")
                .dateNaissanceClient(new SimpleDateFormat("dd-MM-yyyy").parse("08-08-1945"))
                .paysClient("France")
                .actifClient(1)
                .numTVAClient("")
                .refClient(UUID.randomUUID())
                .build();
        cRepo.save(c);

        c = Client.builder()
                .idClient(2L)
                .nomClient("Pompidou")
                .prenomClient("Claude")
                .rueClient("Rue de Matignon")
                .numeroClient("1")
                .cpClient("55922")
                .mailClient("cl.pompidou@gmail.com")
                .dateNaissanceClient(new SimpleDateFormat("dd-MM-yyyy").parse("07-02-1915"))
                .paysClient("France")
                .actifClient(1)
                .numTVAClient("FR9854561066654")
                .refClient(UUID.randomUUID())
                .build();
        cRepo.save(c);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        setupClient();
    }

}
