package com.github.hotire.webservice;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;

import com.github.hotire.webservice.kafka.KafkaConsumer;
import com.github.hotire.webservice.kafka.KafkaProducer;

import lombok.RequiredArgsConstructor;

@SpringBootTest
@DirtiesContext
@EmbeddedKafka(partitions = 1, brokerProperties = { "listeners=PLAINTEXT://localhost:9092", "port=9092" })
@RequiredArgsConstructor
public class EmbeddedKafkaIntegrationTest {
    private final KafkaConsumer consumer;
    private final KafkaProducer producer;
}
