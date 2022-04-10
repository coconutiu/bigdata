package com.nus.bigdata.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * {
 *    "carpark_info":[
 *       {
 *          "total_lots":"350",
 *          "lot_type":"C",
 *          "lots_available":"219"
 *       }
 *    ],
 *    "carpark_number":"AM14",
 *    "update_datetime":"2022-04-10T17:34:36"
 * }
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Parking {
    private List<CarparkInfo> carpark_info;
    private String carpark_number;
    private String update_datetime;
//    private Integer building;
//    //纬度
//    private String latitude;
//    //经度
//    private String longitude;
//    private String postal;
}
