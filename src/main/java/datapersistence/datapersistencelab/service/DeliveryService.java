package datapersistence.datapersistencelab.service;

import datapersistence.datapersistencelab.entity.Delivery;
import datapersistence.datapersistencelab.model.RecipientAndPrice;
import datapersistence.datapersistencelab.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {
    @Autowired
    DeliveryRepository deliveryRepository;

    public Long save(Delivery delivery) {
        delivery.getPlants().forEach(plant -> plant.setDelivery(delivery));
        deliveryRepository.persist(delivery);
        return delivery.getId();
    }

    public RecipientAndPrice getBill(Long deliveryId) {
        return deliveryRepository.getDeliveryPrice(deliveryId);
    }
}