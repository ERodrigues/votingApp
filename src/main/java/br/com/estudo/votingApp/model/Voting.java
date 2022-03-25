package br.com.estudo.votingApp.model;

import br.com.estudo.votingApp.dto.RegistreVote;

import java.util.Calendar;

public class Voting {
    private String nameCandidate;
    private String regionOfVote;
    private Calendar dateVote;

    public Voting(RegistreVote registry){
        this.nameCandidate = registry.getOptionValue();
        this.regionOfVote = "";
        this.dateVote = Calendar.getInstance();
    }
}
