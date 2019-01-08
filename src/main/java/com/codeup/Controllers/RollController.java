package com.codeup.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RollController {
    @GetMapping("/roll-dice/{n}")
    public String rollDice(@PathVariable int n, Model model){
        int roll = (int)(Math.random() * ((5) + 1));
        String message = String.format("You rolled a %d and guessed %d. ", roll, n);


        if(roll == n){
            message += "You guessed correct";
        } else {
            message += "Your guess didn\'t match, guess again.";
        }

        model.addAttribute("message", message);
        return "roll-dice";
    }

    @GetMapping("/roll-dice")
    public String rollDice(){
        return "roll-dice";
    }


}
