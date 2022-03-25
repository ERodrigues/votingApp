package br.com.estudo.votingApp.service;

import br.com.estudo.votingApp.dto.RegistreVote;
import br.com.estudo.votingApp.model.Voting;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

@Service
public class VotingService {

    public void register(RegistreVote registreVote) {
        Voting vote = new Voting(registreVote);
        String jsonVote = getJsonVote(vote);
    }

    private String getJsonVote(Voting voting){
        Gson gson = new Gson();
        return gson.toJson(voting);
    }
}
