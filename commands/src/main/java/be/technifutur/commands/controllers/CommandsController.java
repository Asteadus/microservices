package be.technifutur.commands.controllers;

import be.technifutur.commands.metiers.services.CommandsService;

import be.technifutur.commands.models.dtos.CommandsDTO;
import be.technifutur.commands.models.forms.CommandsForm;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/commands")
public class CommandsController {
    private final CommandsService service;

    public CommandsController(CommandsService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public CommandsDTO getOne(@PathVariable Long id){
        return service.getOne(id);
    }

    @GetMapping
    public List<CommandsDTO> getAll(){
        return service.getAll();
    }

    @PostMapping
    public CommandsDTO insert(@RequestBody CommandsForm form){
        return service.insert(form);
    }

    @DeleteMapping("/{id}")
    public CommandsDTO delete(@PathVariable Long id){
        return service.delete(id);
    }

    @PutMapping("/{id}")
    public CommandsDTO update(@PathVariable Long id, @RequestBody CommandsForm form){
        return service.update(id, form);
    }
}
