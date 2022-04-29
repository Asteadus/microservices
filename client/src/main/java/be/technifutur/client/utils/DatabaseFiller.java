package be.technifutur.client.utils;

import be.technifutur.client.models.Client;
import be.technifutur.client.repositories.ClientRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DatabaseFiller  implements InitializingBean {
    private final ClientRepository cRepo;

    public DatabaseFiller(ClientRepository cRepo) {
        this.cRepo = cRepo;
    }

    private void setupClient(){
        Client c = Client.builder()
                .idClient(1L)
                .nomClient("Balladur")
                .prenomClient("Edouard")
                .rueClient("Rue de l'Elysée")
                .numeroClient("10")
                .cpClient("56922")
                .mailClient("")
                .dateNaissanceClient("08-08-1945")
                .paysClient("France")
                .actifClient(1)
                .numTVAClient("")
                .build();
        cRepo.save(c);

        c = Client.builder()
                .idClient(2L)
                .nomClient("Pompidou")
                .prenomClient("Claude")
                .rueClient("Rue de Matignon")
                .numeroClient("1")
                .cpClient("55922")
                .mailClient("")
                .dateNaissanceClient("08-08-1945")
                .paysClient("France")
                .actifClient(1)
                .numTVAClient("FR9854561066654")
                .build();
        cRepo.save(c);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        setupClient();
    }

}
