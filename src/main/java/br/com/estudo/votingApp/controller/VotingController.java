package br.com.estudo.votingApp.controller;

import br.com.estudo.votingApp.dto.RegistreVote;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/voting")
public class VotingController {

    @GetMapping("/")
    public String getOptions(Model model){
        return "voting";
    }

    @PostMapping("/register")
    public String register(RegistreVote registreVote){
        System.out.println(registreVote.getOptionValue());
        return "voting";
    }
}
