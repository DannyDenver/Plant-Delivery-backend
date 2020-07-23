package datapersistence.datapersistencelab.dao;

import datapersistence.datapersistencelab.model.CandyData;

import java.util.List;

public interface CandyDAO {
    List<CandyData> list();
    void addToDelivery(Long candyId, Long deliveryid);
    List<CandyData> findByDelivery(Long deliveryid);

}
