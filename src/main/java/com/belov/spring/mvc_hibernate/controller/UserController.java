package com.belov.spring.mvc_hibernate.controller;

import com.belov.spring.mvc_hibernate.entity.User;
import com.belov.spring.mvc_hibernate.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/users")
    public String showAllUsers(Model model) {
        List<User> allUsers = usersService.getAllUsers();
        model.addAttribute("allUs", allUsers);
        return "all_users";
    }

    @GetMapping("/add_new_user")
    public String addNewUser(Model model) {
        model.addAttribute("us", new User());
        return "add_user_forma";
    }

    @PostMapping("saveUser")
    public String saveUser(@ModelAttribute("us") User user) {
        usersService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/update_user")
    public String updateUserForm(Model model) {
        model.addAttribute("us", new User());
        return "update_user_forma";
    }

    @PostMapping("updateUser")
    public String updateUser(@ModelAttribute("us") User user) {
        usersService.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/updateInfo")
    public String updateUserInfo(@RequestParam("usID") int id, Model model) {
        model.addAttribute("us", usersService.getUser(id));
        return "update_user_forma";
    }

    @PostMapping("/deleteUser")
    public String removeUser(@RequestParam("usID") int id) {
        usersService.removeUser(id);
        return "redirect:/users";
    }
}
