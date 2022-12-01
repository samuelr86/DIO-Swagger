package dio.swagger.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

        @GetMapping("/welcome")
        public String welcome(){
            return "<h1>Welcome to My Spring Boot Web API</h1>";
        }
}
