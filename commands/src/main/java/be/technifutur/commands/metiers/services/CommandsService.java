package be.technifutur.commands.metiers.services;

import be.technifutur.commands.models.dtos.CommandsDTO;

import be.technifutur.commands.models.forms.CommandsForm;

import java.util.List;

public interface CommandsService {

    CommandsDTO insert(CommandsForm form);

    CommandsDTO getOne(Long id);
    List<CommandsDTO> getAll();

    // UPDATE
    CommandsDTO update( Long id, CommandsForm form );

    // DELETE
    CommandsDTO delete (Long id );
}
