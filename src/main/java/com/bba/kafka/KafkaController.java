package com.bba.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@RequestMapping("/kafka")
@Controller
public class KafkaController {
    private final static Logger logger = LoggerFactory.getLogger(KafkaController.class);

    @Autowired
    KafkaTemplate kafkaTemplate;

    @RequestMapping("publish")
    @ResponseBody
    public String publish(){
        SampleMessage message = new SampleMessage(new Random().nextInt(),"test");
        logger.info("publish message to topic 1: "+ message);
        kafkaTemplate.send("topic1", message.toString());
        return "success:" + message;
    }

}

