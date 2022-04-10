package com.nus.bigdata.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nus.bigdata.entity.Parking;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    @Value("${kafka.topic.carparking-topic1}")
    private String myTopic;

    private final ESService esService;

    private final Logger logger = LoggerFactory.getLogger(ConsumerService.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    public ConsumerService(ESService esService) {
        this.esService = esService;
    }

    @KafkaListener(topics = {"${kafka.topic.carparking-topic1}"}, groupId = "group1")
    public void consumeMessage(ConsumerRecord<String, String> consumerRecord) {

        try {

            Parking parking = objectMapper.readValue(consumerRecord.value(), Parking.class);
//            if(parking.getCarpark_number().equals("A12")){
//                System.out.println("Success ES==="+ consumerRecord.value());
//
//
//            }
            esService.addESParking(parking);
            logger.info("Consume message of topic:{} partition:{} -> {}", consumerRecord.topic(), consumerRecord.partition(), parking.toString());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }


}
