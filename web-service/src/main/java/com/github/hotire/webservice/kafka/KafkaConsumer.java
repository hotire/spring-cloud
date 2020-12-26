package com.github.hotire.webservice.kafka;

import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KafkaConsumer {

    @Getter
    private final CountDownLatch latch = new CountDownLatch(1);

    @KafkaListener(topics = "${test.topic}")
    public void receive(ConsumerRecord<?, ?> consumerRecord, Acknowledgment ack) {
        log.info("received payload='{}'", consumerRecord);
        ack.acknowledge();
    }

}
