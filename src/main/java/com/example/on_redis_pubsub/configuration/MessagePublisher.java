package com.example.on_redis_pubsub.configuration;

public interface MessagePublisher {
    void publish(String message);
}
