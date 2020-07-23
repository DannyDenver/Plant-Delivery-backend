package datapersistence.datapersistencelab.repository;

import datapersistence.datapersistencelab.entity.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
@EnableJpaRepositories
public interface PlantRepository extends JpaRepository<Plant, Long> {

//    Boolean existsPlantByIdAndDeliveryCompleted(Long id, Boolean delivered);

    @Query("select p.delivery.completed from Plant p where p.id = :plantId")
    Boolean deliveryCompleted(Long plantId);

    List<Plant> findByPriceLessThan(BigDecimal price);

}
