package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.service.UserService;
import web.model.User;


import java.util.List;


@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService service) {
        this.userService = service;
    }

    @GetMapping(value = "/all")
    public String showAllUsers(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers",allUsers);
        return "allUsers";
    }


    @GetMapping(value = "/new")
    public String newUser(Model model) {
        model.addAttribute("user",new User());
        return "newUsers";
    }

    @PostMapping()
    public String createUser( User user) {
        userService.saveUser(user);
        return "redirect:/users/all";
    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam("id") long id) {
        model.addAttribute("user",userService.getUserById(id));
        return "editit";
    }

    @PatchMapping("/id")
    public String update( User user,@RequestParam("id") long id) {
        userService.updateUser(user);
        return "redirect:/users/all";
    }

    @DeleteMapping("/id")
    public String delete(@RequestParam("id") long id) {
        userService.deleteUser( id);
        return "redirect:/users/all";
    }
}