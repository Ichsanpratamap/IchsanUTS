package com.example.ichsan.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import com.example.ichsan.demo.service.UserServices;
import com.example.ichsan.demo.model.User;

@Controller
public class UserController {

    @Autowired
    private UserServices userServices;

    @GetMapping("/")
    public String index() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", "Username atau Password salah");
        }
        return "login";
    }

    @GetMapping("/register")
    public String registPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

//     @PostMapping("/register")
//     public String processRegistration(@ModelAttribute("user") User user) {
//     userServices.saveUser(user); 
//     return "redirect:/login";  
// }


    @PostMapping("/add-user")
    public String addUser(@ModelAttribute User user) {
        userServices.saveUser(user);
        return "redirect:/login";
    }

    @PostMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable String id) {
        userServices.deleteUser(id);
        return "redirect:/todos";
    }
}
