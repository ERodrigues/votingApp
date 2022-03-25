package br.com.estudo.votingApp.service;

import br.com.estudo.votingApp.dto.RegistreVote;
import br.com.estudo.votingApp.model.Voting;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotingService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void register(RegistreVote registreVote) {
        Voting vote = new Voting(registreVote);
        rabbitTemplate.convertAndSend("vote", getJsonVote(vote));
    }

    private String getJsonVote(Voting voting){
        Gson gson = new Gson();
        return gson.toJson(voting);
    }
}
