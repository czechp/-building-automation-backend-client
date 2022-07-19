package app.web.pczportfolio.pczautomationclient.clientConfiguration.adapter;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/home")
@CrossOrigin("*")
public class HomeRestController {
    @GetMapping
    String homeEndpoint() {
        return "Client Application works";
    }

}
