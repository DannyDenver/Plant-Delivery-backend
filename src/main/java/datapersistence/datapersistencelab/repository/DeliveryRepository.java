package datapersistence.datapersistencelab.repository;

import datapersistence.datapersistencelab.entity.Delivery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class DeliveryRepository {
    @PersistenceContext
    EntityManager entityManager;

    void persist(Delivery delivery) {
        entityManager.persist(delivery);
    }

    Delivery find(Long id) {
        return entityManager.find(Delivery.class, id);
    }

    Delivery merge(Delivery delivery) {
        return entityManager.merge(delivery);
    }

    void delete(Long id) {
        Delivery delivery = entityManager.find(Delivery.class, id);
        entityManager.remove(delivery);
    }
}
