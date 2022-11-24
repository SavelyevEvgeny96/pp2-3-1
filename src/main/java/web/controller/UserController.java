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



    @GetMapping()
    public String showAllUsers(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("users", allUsers);
        return "allUsers";
    }


    @GetMapping(value = "/new")
    public String newUser(@ModelAttribute("user")User user) {
        return "newUser";
    }

    @PostMapping()
    public String createUser( User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping()
    public String edit(Model model, @RequestParam(value = "id") long id) {
        model.addAttribute("user",userService.getUserById(id));
        return "edit";
    }

    @PatchMapping()
    public String update( User user,@RequestParam(value = "id") long id) {
        userService.updateUser(user,id);
        return "redirect:/users";
    }

    @DeleteMapping()
    public String delete(@RequestParam("id") long id) {
        userService.deleteUser( id);
        return "redirect:/users";
    }
}