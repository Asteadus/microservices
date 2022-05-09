package be.technifutur.client.controllers;

import be.technifutur.client.models.Client;
import be.technifutur.client.models.ClientDto;
import be.technifutur.client.models.ClientForm;
import be.technifutur.client.services.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class ClientController {
    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

//    // GET - http://localhost:8080/user
//    //    @RequestMapping(method = RequestMethod.GET, path="/user")
//    @GetMapping("")
//    public List<Client> getAll() {
//        return service.getAll();
//    }

    // GET - http://localhost:8080/user/id
    //    @ResponseStatus(HttpStatus.OK)
//    @GetMapping("/{id}")
//    public String getUserById(@PathVariable Long id, Model model){
//        Client c = service.getUserById(id);
//        model.addAttribute("client", c);
//        return "forms/clientidform";
//    }

    // PUT - http://localhost:8080/user/id/update
    //    @ResponseStatus(HttpStatus.OK)
//    @PutMapping("/{id}/update")
////    @PreAuthorize("isAuthenticated()")
//    public String updateUser(@Valid @ModelAttribute("client") ClientForm form, BindingResult binding){
//        if (binding.hasErrors())
//            return "forms/clientupdateform";
//        Client rslt = service.update(form);
//        return "redirect:/user/" + rslt.getIdClient();
//    }

    // PUT - http://localhost:8080/user/id/delete
    //    @ResponseStatus(HttpStatus.OK)
//    @DeleteMapping("/{id}/delete")
////    @PreAuthorize("isAuthenticated()")
//    public String deleteUserById(@PathVariable Long id, @Valid @ModelAttribute("client") ClientForm form, BindingResult binding){
//        if (binding.hasErrors())
//            return "forms/clientdeleteform";
//        Client rslt = service.delete(form);
//        return "redirect:/user/" + rslt.getIdClient();
//    }

    @GetMapping
//    @PreAuthorize("permitAll()")
    public List<ClientDto> displayAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ClientDto getClientById(@PathVariable Long id) {
        return (this.service.getUserById(id));
    }

    // GET - http://localhost:8080/user/reference?{ref}
    @GetMapping("/user")
    public ClientDto getClientByRef(@RequestParam(name = "ref") UUID ref) {
        System.out.println(ref);
        return (this.service.getUserByRef(ref));
    }

//    @ExceptionHandler(NoSuchElementException.class)
//    public String handle(NoSuchElementException ex){
//        return "pages/404";
//    }

//    @GetMapping("/add")
////    @PreAuthorize("isAuthenticated()")
//    public String displayInsertForm(@ModelAttribute("client") ClientForm form){
//        return "forms/clientform";
//    }

    // POST - http://localhost:8080/user/add
    //    @RequestMapping(method = RequestMethod.GET, path="/user")
//    @PostMapping("/add")
////    @PreAuthorize("isAuthenticated()")
//    public String addUser(@Valid @ModelAttribute("client") ClientForm form, BindingResult binding){
//        if (binding.hasErrors())
//            return "forms/clientaddform";
//        Client rslt = service.insert(form);
//        return "redirect:/user/" + rslt.getIdClient();
//    }

//    @GetMapping("/select")
////    @PreAuthorize("isAuthenticated()")
//    public String displaySelectForm(@ModelAttribute("client") ClientForm form){
//        return "forms/clientform";
//    }

//    @GetMapping("/update")
////    @PreAuthorize("isAuthenticated()")
//    public String displayUpdateForm(@ModelAttribute("client") ClientForm form){
//        return "forms/clientform";
//    }
}
