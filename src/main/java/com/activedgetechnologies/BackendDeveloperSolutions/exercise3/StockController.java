package com.activedgetechnologies.BackendDeveloperSolutions.exercise3;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;


@RestController
@RequestMapping("/api/stocks")
@RequiredArgsConstructor
public class StockController {
    private final StockDataInitializer stockDataInitializer;
    private final ResponseProvider responseProvider;


    @PostMapping
    public ResponseEntity<ApiResponse>createStock(@RequestBody Stock stock){
        stock.setId(generateNewId());
        stock.setCreateDate(new Timestamp(System.currentTimeMillis()));
        stock.setLastUpdate(stock.getCreateDate());
        stockDataInitializer.getStocks().add(stock);
        return new ResponseEntity<>(responseProvider.success("Stock created successfully"), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse>getStockById( @PathVariable Long id){
        for (Stock stock : stockDataInitializer.getStocks()) {
            if (stock.getId().equals(id)) {
                return new ResponseEntity<>(responseProvider.success(stock), HttpStatus.OK);
            }
        }
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse>updateStockPrice( @PathVariable Long id, @RequestBody Stock stock){

        List<Stock> stocks = stockDataInitializer.getStocks();
        for (Stock stockToUpdate : stocks) {
            if (stockToUpdate.getId().equals(id)) {
                stockToUpdate.setCurrentPrice(stock.getCurrentPrice());
                stockToUpdate.setLastUpdate(new Timestamp(System.currentTimeMillis()));
                return new ResponseEntity<>(responseProvider.success(stockToUpdate), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(responseProvider.error("Stock not found with ID: " + id), HttpStatus.NOT_FOUND);
    }


    @GetMapping()
    public ResponseEntity<ApiResponse>getStocks(){
        List<Stock> stocks = stockDataInitializer.getStocks();
        if (stocks.isEmpty()) {
            return new ResponseEntity<>(responseProvider.error("No stocks found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(responseProvider.success(stocks), HttpStatus.OK);
    }

    private synchronized Long generateNewId() {
        return stockDataInitializer.getStocks().size() + 1L;
    }
}
