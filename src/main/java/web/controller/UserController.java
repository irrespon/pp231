package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.model.User;
import web.service.UserService;
import web.service.UserServiceImpl;

import java.util.List;

@Controller
public class UserController {

    private UserService userService = new UserServiceImpl();

    @GetMapping("/")
    public String allUsers(Model model) {
        List<User> users = userService.allUsers();
        model.addAttribute("users",users);
        return "users";
    }

    @GetMapping("/edit")
    public String editPage() {
        return "editPage";
    }
}
