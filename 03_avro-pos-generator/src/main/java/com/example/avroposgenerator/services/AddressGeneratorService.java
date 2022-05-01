package com.example.avroposgenerator.services;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Random;

@Service
public class AddressGeneratorService {
    private final Random random;
    private final com.example.avroposgenerator.model.DeliveryAddress[] addresses;

    public AddressGeneratorService(){
        final String DATAFILE = "src/main/resources/data/Address.json";
        final ObjectMapper objectMapper;
        random = new Random();
        objectMapper = new ObjectMapper();

        try {
            addresses = objectMapper.readValue(new File(DATAFILE) , com.example.avroposgenerator.model.DeliveryAddress[].class);
        }catch (Exception exception){
            throw new RuntimeException(exception);
        }
    }

    private int getIndex(){
        return random.nextInt(100);
    }
    public com.example.avroposgenerator.model.DeliveryAddress getNextAddress(){
        return addresses[getIndex()];
    }



}
