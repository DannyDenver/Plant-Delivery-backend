package datapersistence.datapersistencelab.service;

import datapersistence.datapersistencelab.entity.Plant;
import org.springframework.stereotype.Service;

@Service
public class PlantService {
    public Plant getPlantByName(String name){
        return new Plant();
    }
}
