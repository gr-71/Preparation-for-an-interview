package sixth.lesson.homework.server;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class Controller {

    @GetMapping
    public String hello(@RequestParam(name = "name") String name){
        return "Hello, " + name + " !";
    }

    @PostMapping
    public String createNewUser(@RequestParam(name = "userName") String userName, @RequestParam(name = "password") String password){
        return "There was created new user " + " with password \"" + password;
    }

}

