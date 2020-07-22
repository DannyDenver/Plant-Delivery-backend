package datapersistence.datapersistencelab.service;

import datapersistence.datapersistencelab.entity.Plant;
import datapersistence.datapersistencelab.entity.Shrub;
import datapersistence.datapersistencelab.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PlantService {
    @Autowired
    PlantRepository plantRepository;

    public Plant getPlantByName(String name){
        Shrub shrub = new Shrub();
        shrub.setName("lil shrubby shrub");
        return shrub;
    }

    public Long savePlant(Plant plant) {
        return plantRepository.save(plant).getId();
    }

    public boolean plantHasBeenDelivered(Long id) {
        return plantRepository.deliveryCompleted(id);
    }

    public List<Plant> findPlantsCheaperThan(BigDecimal price) {
        return plantRepository.findAByPriceLessThan(price);
    }
}
