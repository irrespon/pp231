package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.model.User;

@Controller
public class UserController {

    private static User user;

    static {
        user = new User("alex","kor");
    }

    @GetMapping("/")
    public String allUsers(Model model) {
        model.addAttribute("user",user);
        return "users";
    }

    @GetMapping("/edit")
    public String editPage() {
        return "editPage";
    }
}
