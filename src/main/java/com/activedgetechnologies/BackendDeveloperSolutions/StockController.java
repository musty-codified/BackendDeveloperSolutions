package com.activedgetechnologies.BackendDeveloperSolutions;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;


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
        return null;
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse>updateStockPrice( @PathVariable Long id, @RequestBody StockDto stockDto){

        return null;
    }

    @GetMapping()
    public ResponseEntity<ApiResponse>getStocks(){

        return null;
    }

    private synchronized Long generateNewId() {
        return stockDataInitializer.getStocks().size() + 1L;
    }
}
