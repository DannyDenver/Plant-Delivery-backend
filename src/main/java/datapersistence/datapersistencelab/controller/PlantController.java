package datapersistence.datapersistencelab.controller;

import com.fasterxml.jackson.annotation.JsonView;
import datapersistence.datapersistencelab.DTO.PlantDTO;
import datapersistence.datapersistencelab.entity.Plant;
import datapersistence.datapersistencelab.service.PlantService;
import datapersistence.datapersistencelab.views.Views;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plant")
public class PlantController {

    @Autowired
    private PlantService plantService;

    public PlantDTO getPlantDTO(String name){
        Plant plant = plantService.getPlantByName(name);
        return toPlantDTO(plant);
    }

    @JsonView(Views.Public.class)
    public Plant getFilteredPlant(String name){
        return plantService.getPlantByName(name);
    }

    public PlantDTO toPlantDTO(Plant plant) {
        PlantDTO plantDTO = new PlantDTO();
        BeanUtils.copyProperties(plant, plantDTO);
        return plantDTO;
    }
}