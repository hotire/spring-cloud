package com.github.hotire.webservice;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.TestConstructor.AutowireMode;

import com.github.hotire.webservice.kafka.KafkaConsumer;
import com.github.hotire.webservice.kafka.KafkaProducer;

import lombok.RequiredArgsConstructor;

@SpringBootTest
@DirtiesContext
@EmbeddedKafka(partitions = 1, brokerProperties = { "listeners=PLAINTEXT://localhost:9092", "port=9092" })
@TestConstructor(autowireMode = AutowireMode.ALL)
@RequiredArgsConstructor
class EmbeddedKafkaIntegrationTest {
    private final KafkaConsumer consumer;
    private final KafkaProducer producer;

    @Value("${test.topic}")
    private String topic;

    @Test
    void send() throws InterruptedException {
        // given
        producer.send(topic, "hello");
        consumer.getLatch().await(1000L, TimeUnit.MILLISECONDS);

        // no assert
    }

}
