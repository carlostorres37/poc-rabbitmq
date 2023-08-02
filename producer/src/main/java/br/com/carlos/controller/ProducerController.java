package br.com.carlos.controller;

import br.com.carlos.config.MQConfig;
import br.com.carlos.domain.CustomMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/producer")
public class ProducerController {

    @Autowired
    private RabbitTemplate template;

    @GetMapping
    public void sendMessage(@RequestParam String message) {
        CustomMessage customMessage = CustomMessage.builder()
                .message(message)
                .messageId(UUID.randomUUID().toString())
                .messageDate(new Date())
                .build();
        template.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY, customMessage);
    }
}
