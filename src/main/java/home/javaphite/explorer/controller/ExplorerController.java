package home.javaphite.explorer.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
@EnableAutoConfiguration
public class ExplorerController {

    @GetMapping("/location")
    public String getLocation() {
        return "location";
    }
}
