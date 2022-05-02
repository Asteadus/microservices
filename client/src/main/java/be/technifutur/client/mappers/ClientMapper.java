package be.technifutur.client.mappers;

import be.technifutur.client.models.Client;
import be.technifutur.client.models.ClientDto;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class ClientMapper {
    public ClientDto entity2Dto(Client entity) {
        if(entity == null) {
            return null;
        }
        return ClientDto.builder()
                .idClient(entity.getIdClient())
                .nomClient(entity.getNomClient())
                .prenomClient(entity.getPrenomClient())
                .rueClient(entity.getRueClient())
                .numeroClient(entity.getNumeroClient())
                .cpClient(entity.getCpClient())
                .mailClient(entity.getMailClient())
                .dateNaissanceClient(entity.getDateNaissanceClient())
                .paysClient(entity.getPaysClient())
                .actifClient(entity.getActifClient())
                .numTVAClient(entity.getNumTVAClient())
                .refClient(entity.getRefClient())
                .build();
    }
}
