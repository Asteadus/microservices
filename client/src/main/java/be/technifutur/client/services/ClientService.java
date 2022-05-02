package be.technifutur.client.services;

import be.technifutur.client.exceptions.ElementNotFoundException;
import be.technifutur.client.mappers.ClientMapper;
import be.technifutur.client.models.Client;
import be.technifutur.client.models.ClientDto;
import be.technifutur.client.models.ClientForm;
import be.technifutur.client.repositories.ClientRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class ClientService {
    private Long nextIdClient = 3L;
    private final ClientRepository cRepo;
    private final ClientMapper mapper;

    public ClientService(ClientRepository cRepo, ClientMapper mapper) {
        this.cRepo = cRepo;
        this.mapper = mapper;
    }

    public ClientDto getUserById(Long id){
        return cRepo.findById(id).map(mapper::entity2Dto).orElseThrow(() -> new ElementNotFoundException(id, ClientDto.class));
    }

    public ClientDto getUserByRef(UUID ref){
        return this.cRepo.findByReference(ref)
                .map(mapper::entity2Dto)
                .orElseThrow(() -> new ElementNotFoundException(ref, ClientDto.class));

    }

    public List<ClientDto> getAll(){
        return cRepo.findAll().stream().map(mapper::entity2Dto).toList();
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
                .refClient(UUID.randomUUID())
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
                .refClient(form.getRefClient())
                .build();
        client = cRepo.save(client);
        return client;
    }

    public Client delete(ClientForm form){
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
                .actifClient(0)
                .numTVAClient(form.getNumTVAClient())
                .refClient(form.getRefClient())
                .build();
        cRepo.save(client);
        return client;
    }
}
