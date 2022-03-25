package br.com.estudo.votingApp.controller;

import br.com.estudo.votingApp.dto.RegistreVote;
import br.com.estudo.votingApp.service.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/voting")
public class VotingController {

    @Autowired
    private VotingService votingService;

    @GetMapping("/")
    public String getOptions(Model model){
        return "voting";
    }

    @PostMapping("/register")
    public String register(RegistreVote registreVote){
        votingService.register(registreVote);
        return "voting";
    }
}
