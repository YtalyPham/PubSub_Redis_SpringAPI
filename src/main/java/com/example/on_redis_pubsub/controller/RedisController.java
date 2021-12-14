package com.example.on_redis_pubsub.controller;

import com.example.on_redis_pubsub.configuration.RedisMessagePublisher;
import com.example.on_redis_pubsub.configuration.RedisMessageSubcriber;
import com.example.on_redis_pubsub.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/redis")
public class RedisController {
    private static Logger logger= LoggerFactory.getLogger(RedisController.class);

    @Autowired
    private RedisMessagePublisher messagePublisher;

    @PostMapping("/publish")
    public void publish(@RequestBody Message message){
        logger.info(">> publishing: {}",message);
        messagePublisher.publish(message.toString());
    }

    @GetMapping("/subscribe")
    public List<String> getMessage(){
        return RedisMessageSubcriber.messageList;
    }


}
