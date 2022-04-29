package be.technifutur.client.services;

import be.technifutur.client.models.Client;
import be.technifutur.client.models.ClientForm;
import be.technifutur.client.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.List;

@Service
public class ClientService {
    private Long nextIdClient = 3L;
    private final ClientRepository cRepo;

    public ClientService(ClientRepository cRepo) {
        this.cRepo = cRepo;
    }

    public Client getOne(Long id){
        return cRepo.getById(id);
    }

    public List<Client> getAll(){
        return cRepo.findAll();
    }

    public Client insert(ClientForm form){
        Client client = Client.builder()
                .idClient(++nextIdClient)
                .nomClient(form.getNomClient())
                .prenomClient(form.getPrenomClient())
                .rueClient(form.getRueClient())
                .numeroClient(form.getNumeroClient())
                .cpClient(form.getCpClient())
                .mailClient(form.getMailClient())
                .dateNaissanceClient(form.getDateNaissanceClient())
                .paysClient(form.getPaysClient())
                .actifClient(form.getActifClient())
                .numTVAClient(form.getNumTVAClient())
                .build();
        cRepo.save(client);
        return client;
    }

    public Client update(ClientForm form){
        Client client = Client.builder()
                .idClient(form.getIdClient())
                .nomClient(form.getNomClient())
                .prenomClient(form.getPrenomClient())
                .rueClient(form.getRueClient())
                .numeroClient(form.getNumeroClient())
                .cpClient(form.getCpClient())
                .mailClient(form.getMailClient())
                .dateNaissanceClient(form.getDateNaissanceClient())
                .paysClient(form.getPaysClient())
                .actifClient(form.getActifClient())
                .numTVAClient(form.getNumTVAClient())
                .build();
        cRepo.save(client);
        return client;
    }
}
