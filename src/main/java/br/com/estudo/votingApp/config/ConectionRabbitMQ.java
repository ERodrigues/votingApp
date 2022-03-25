package br.com.estudo.votingApp.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ConectionRabbitMQ {
    private final String QUEUENAME = "vote";
    private final String EXCHANGENAME = "amq.direct";
    private AmqpAdmin amqpAdmin;

    public ConectionRabbitMQ(AmqpAdmin amqpAdmin){
        this.amqpAdmin = amqpAdmin;
    }

    private Queue getQueue(){
        return new Queue(QUEUENAME, true, false, false);
    }

    private DirectExchange getExchange(){
        return new DirectExchange(EXCHANGENAME);
    }

    private Binding getBinding(Queue queue, DirectExchange directExchange){
        return new Binding(queue.getName(), Binding.DestinationType.QUEUE, directExchange.getName(), queue.getName(), null);
    }

    @PostConstruct
    private void createQueues(){
        Queue queueVote = this.getQueue();
        DirectExchange directExchange = this.getExchange();
        Binding binding = this.getBinding(queueVote, directExchange);

        amqpAdmin.declareQueue(queueVote);
        amqpAdmin.declareExchange(directExchange);
        amqpAdmin.declareBinding(binding);
    }
}
