package com.nus.bigdata.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Data
@Document(indexName = "parking1",createIndex = true)
public class ESParking {
    @Id
    @Field(type = FieldType.Text)
    private String id;

    @Field(type = FieldType.Object)
//    @Field(type = FieldType.Nested, includeInParent = true)
    private List<ESCarparkinfo> carpark_info;

    @Field(type = FieldType.Text)
    private String carpark_number;

    @Field(type = FieldType.Text)
//    @Field(type = FieldType.Date,format = DateFormat.basic_date_time)
    private String update_datetime;

}
