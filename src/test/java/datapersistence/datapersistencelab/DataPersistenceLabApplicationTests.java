package datapersistence.datapersistencelab;

import datapersistence.datapersistencelab.entity.Delivery;
import datapersistence.datapersistencelab.entity.Plant;
import datapersistence.datapersistencelab.repository.PlantRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@DataJpaTest
class DataPersistenceLabApplicationTests {
	@Autowired
	PlantRepository plantRepository;

	@Autowired
	TestEntityManager testEntityManager;

	@Test
	void contextLoads() {
	}

	@Test
	void testPriceLessThan() {
		Plant plant = testEntityManager.persist(new Plant("Leafy", 4.99));
		testEntityManager.persist(new Plant("Barky", 5.99));

		List<Plant> plants = plantRepository.findByPriceLessThan(BigDecimal.valueOf(5));

		Assertions.assertEquals(plants.size(), 1);
		Assertions.assertEquals(plants.get(0), plant);
	}

	@Test
	void testDeliveryCompleted() {
		Plant p = testEntityManager.persist(new Plant("Leafy", 4.99));

		Delivery d = testEntityManager.persist(new Delivery("Bob", "4101 SW 7th", LocalDateTime.now()));

		d.setPlants(Lists.newArrayList(p));
		p.setDelivery(d);

		Assertions.assertFalse(plantRepository.deliveryCompleted(p.getId()));
		d.setCompleted(true);

		Assertions.assertTrue(plantRepository.deliveryCompleted(p.getId()));
	}



}
