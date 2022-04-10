package com.nus.bigdata.service;

import com.nus.bigdata.entity.CarparkInfo;
import com.nus.bigdata.entity.ESCarparkinfo;
import com.nus.bigdata.entity.ESParking;
import com.nus.bigdata.entity.Parking;
import com.nus.bigdata.repository.ESRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class ESService {
    private final ESRepository esRepository;

    public ESService(ESRepository esRepository) {
        this.esRepository = esRepository;
    }

    public void addESParking(Parking parking) {

        ESParking esParking = new ESParking();
//        BeanUtils.copyProperties(saveBook, esBook);
//        esParking.setId(parking.getId());
        List<ESCarparkinfo> esCarparkInfoList = new ArrayList<>();
        List<CarparkInfo> carparkinfoList = parking.getCarpark_info();
        for(CarparkInfo carparkInfo:carparkinfoList){
            if(carparkInfo == null){
                continue;
            }
            ESCarparkinfo esCarparkinfo = new ESCarparkinfo();
            esCarparkinfo.setLot_type(carparkInfo.getLot_type());
            esCarparkinfo.setLots_available(carparkInfo.getLots_available());
            esCarparkinfo.setTotal_lots(carparkInfo.getTotal_lots());
            esCarparkInfoList.add(esCarparkinfo);
        }
        esParking.setCarpark_info(esCarparkInfoList);
        esParking.setCarpark_number(parking.getCarpark_number());
        esParking.setUpdate_datetime(parking.getUpdate_datetime());
        UUID uuidId = UUID.randomUUID();
        esParking.setId(uuidId.toString());
        try {
            esRepository.save(esParking);
        }catch (Exception e){
            log.error(String.format("保存ES错误！%s", e.getMessage()));
        }
    }

}
