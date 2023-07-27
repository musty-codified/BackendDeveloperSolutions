package com.activedgetechnologies.BackendDeveloperSolutions;

import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@Component
@Data
public class StockDataInitializer implements CommandLineRunner {



    private List<Stock> stocks = new ArrayList<>();
    private AtomicLong idGenerator = new AtomicLong(1);
    @Override
    public void run(String... args) throws Exception {

        stocks.add(new Stock(idGenerator.getAndIncrement(), "Apple Inc.", BigDecimal.valueOf(145.67),
                new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis())));
        stocks.add(new Stock(idGenerator.getAndIncrement(), "Microsoft Corporation", BigDecimal.valueOf(301.32),
                new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis())));
        stocks.add(new Stock(idGenerator.getAndIncrement(), "Amazon.com Inc.", BigDecimal.valueOf(3423.67),
                new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis())));
        stocks.add(new Stock(idGenerator.getAndIncrement(), "Google LLC", BigDecimal.valueOf(2750.25),
                new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis())));
        stocks.add(new Stock(idGenerator.getAndIncrement(), "FaceBook.com Inc", BigDecimal.valueOf(4550.25),
                new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis())));
}
}
