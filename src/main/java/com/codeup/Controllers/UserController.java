package com.codeup.Controllers;

import com.codeup.Models.User;
import com.codeup.Repositories.Users;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private Users users;
    private PasswordEncoder passwordEncoder;

    public UserController(Users users, PasswordEncoder passwordEncoder){
        this.users = users;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        return "users/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        users.save(user);
        return "redirect:/login";
    }

    @GetMapping("/edit-profile")
    public String showEditForm(Model model){
        model.addAttribute("user", (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "users/edit";
    }

    @PostMapping("/edit-profile")
    public String saveEdit(@ModelAttribute User user){
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //confirm both users are the same
        System.out.println(user.getId());
        if(currentUser.getId() == user.getId()){
            System.out.println(user.getId());
            user.setPassword(currentUser.getPassword());
            user.setId(currentUser.getId());
        }
        users.save(user);
        return "users/edit";
    }

}
