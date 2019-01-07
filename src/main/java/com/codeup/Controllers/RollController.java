package com.codeup.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RollController {
    @GetMapping("/roll-dice/n")
    public String rollDice(@PathVariable int n, Model model){
        int roll = (int)(Math.random() * ((5) + 1));
        String message = "Incorrect, roll again";


        if(roll == n){
            message = "You guessed correct";
        }

        model.addAttribute("message", message);
        model.addAttribute("guess", n);
        model.addAttribute("roll", roll);
        return "roll-dice";
    }

    @GetMapping("/roll-dice")
    public String rollDice(){
        return "roll-dice";
    }
}
