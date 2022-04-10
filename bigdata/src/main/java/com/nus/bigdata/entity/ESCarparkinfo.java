package com.nus.bigdata.entity;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
//@Document(indexName = "carparkinfo",createIndex = true)
public class ESCarparkinfo {
    @Field(type = FieldType.Text)
    private String total_lots;

    @Field(type = FieldType.Text)
    private String lot_type;

    @Field(type = FieldType.Text)
    private String lots_available;
}
