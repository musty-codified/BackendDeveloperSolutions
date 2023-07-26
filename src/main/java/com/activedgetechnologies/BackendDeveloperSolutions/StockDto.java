package com.activedgetechnologies.BackendDeveloperSolutions;


import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class StockDto {
    private String name;
    private BigDecimal currentPrice;
    private Timestamp createDate;
    private Timestamp lastUpdate;
}
