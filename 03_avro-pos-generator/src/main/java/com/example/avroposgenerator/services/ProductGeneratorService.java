package com.example.avroposgenerator.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Random;

@Service
public class ProductGeneratorService {

    private final Random random;
    private final Random qty;
    private final com.example.avroposgenerator.model.LineItem[] products;

    public ProductGeneratorService() {
        String DATAFILE = "src/main/resources/data/Product.json";
        ObjectMapper mapper = new ObjectMapper();
        random = new Random();
        qty = new Random();
        try {
            products = mapper.readValue(new File(DATAFILE), com.example.avroposgenerator.model.LineItem[].class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private int getIndex() {
        return random.nextInt(100);
    }

    private int getQuantity() {
        return qty.nextInt(2) + 1;
    }

    public com.example.avroposgenerator.model.LineItem getNextProduct() {
        com.example.avroposgenerator.model.LineItem lineItem = products[getIndex()];
        lineItem.setItemQty(getQuantity());
        lineItem.setTotalValue(lineItem.getItemPrice() * lineItem.getItemQty());
        return lineItem;
    }
}
