package be.technifutur.commands.metiers.services.impl;

import be.technifutur.commands.data.repo.ClientRepository;
import be.technifutur.commands.data.repo.CommandsRepository;
import be.technifutur.commands.metiers.services.CommandsService;
import be.technifutur.commands.models.dtos.CommandsDTO;
import be.technifutur.commands.models.entities.Commands;
import be.technifutur.commands.models.forms.CommandsForm;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CommandsServiceImpl implements CommandsService {
    private final CommandsRepository repository;
    private final ClientRepository cRepo;

    public CommandsServiceImpl(CommandsRepository repository, ClientRepository cRepo) {
        this.repository = repository;
        this.cRepo = cRepo;
    }

    @Override
    public CommandsDTO insert(CommandsForm form) {
        Commands commands = Commands.builder()
                .refCommands(UUID.randomUUID())
                .date(form.getDate())
                .productOrders(form.getProductOrders())
                .build();
                if(form.getClientID() != null)
                    commands.setClients(
                            cRepo.findById(form.getClientID())
                                    .orElseThrow()
                );
        return CommandsDTO.of(repository.save(commands));
    }

    @Override
    public CommandsDTO getOne(Long id) {
        return repository.findById(id)
                .map(CommandsDTO::of)
                .orElseThrow();
    }

    @Override
    public List<CommandsDTO> getAll() {
        return repository.findAll().stream()
                .map(CommandsDTO::of)
                .toList();
    }

    @Override
    public CommandsDTO update(Long id, CommandsForm form) {
        Commands entity = repository.findById(id)
                .orElseThrow();
        entity.setProductOrders(form.getProductOrders());
        entity.setDate(form.getDate());
        return CommandsDTO.of( repository.save(entity) );
    }



    @Override
    public CommandsDTO delete(Long id) {
        CommandsDTO dto = getOne(id);
        repository.deleteById(id);
        return dto;
    }
}
