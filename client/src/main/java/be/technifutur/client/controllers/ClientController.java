package be.technifutur.client.controllers;

import be.technifutur.client.models.Client;
import be.technifutur.client.models.ClientForm;
import be.technifutur.client.services.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/user")
public class ClientController {
    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

//    // GET - http://localhost:8080/auteur
//    //    @RequestMapping(method = RequestMethod.GET, path="/auteur")
//    @GetMapping("")
//    public List<Auteur> getAll() {
//        return service.getAll();
//    }

    // GET - http://localhost:8080/auteur/id
    //    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public String displayOne(@PathVariable Long id, Model model){
        Client c = service.getOne(id);
        model.addAttribute("client", c);
        return "forms/client/clientidform";
    }

    @PostMapping("/{id}")
//    @PreAuthorize("isAuthenticated()")
    public String processUpdate(@Valid @ModelAttribute("client") ClientForm form, BindingResult binding){
        if (binding.hasErrors())
            return "forms/client/clientform";
        Client rslt = service.update(form);
        return "redirect:/client/" + rslt.getIdClient();
    }

    @GetMapping
//    @PreAuthorize("permitAll()")
    public String displayAll(Model model){
        List<Client> list = service.getAll();
        model.addAttribute("client_liste", list);
        return "pages/client/displayAllClient";
    }

    @ExceptionHandler(NoSuchElementException.class)
    public String handle(NoSuchElementException ex){
        return "pages/misc/404";
    }

    @GetMapping("/add")
//    @PreAuthorize("isAuthenticated()")
    public String displayInsertForm(@ModelAttribute("client") ClientForm form){
        return "forms/client/clientform";
    }

    @PostMapping("/add")
//    @PreAuthorize("isAuthenticated()")
    public String processInsert(@Valid @ModelAttribute("auteur") ClientForm form, BindingResult binding){
        if (binding.hasErrors())
            return "forms/client/clientform";
        Client rslt = service.insert(form);
        return "redirect:/client/" + rslt.getIdClient();
    }

    @GetMapping("/select")
//    @PreAuthorize("isAuthenticated()")
    public String displaySelectForm(@ModelAttribute("client") ClientForm form){
        return "forms/client/clientform";
    }

    @GetMapping("/update")
//    @PreAuthorize("isAuthenticated()")
    public String displayUpdateForm(@ModelAttribute("client") ClientForm form){
        return "forms/client/clientform";
    }
}
