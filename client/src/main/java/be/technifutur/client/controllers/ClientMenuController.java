package be.technifutur.client.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class ClientMenuController {
    @GetMapping
//    @PreAuthorize("permitAll()")
    public String displayUsagerMaintenance(){
        return "pages/menuClientMaintenance";
    }
}
