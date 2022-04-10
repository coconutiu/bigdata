package com.nus.bigdata.repository;

import com.nus.bigdata.entity.ESParking;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ESRepository extends ElasticsearchRepository<ESParking, String> {
//    List<ESParking> findByCarpark_number(String carpark_number);



}
