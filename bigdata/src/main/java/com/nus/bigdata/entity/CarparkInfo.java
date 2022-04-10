package com.nus.bigdata.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarparkInfo {
    private String total_lots;
    private String lot_type;
    private String lots_available;
}
