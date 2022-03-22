package br.com.estudo.votingApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VotingController {

    @GetMapping("/voting")
    public String getOptions(Model model){
        return "voting";
    }
}
