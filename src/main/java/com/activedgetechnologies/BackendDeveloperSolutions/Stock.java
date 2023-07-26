package com.activedgetechnologies.BackendDeveloperSolutions;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Stock {
    private Long id;
    private String name;
    private BigDecimal currentPrice;
    private Timestamp createDate;
    private Timestamp lastUpdate;

    public Stock(Long id, String name, BigDecimal currentPrice) {
        this.id = id;
        this.name = name;
        this.currentPrice = currentPrice;
    }
}
