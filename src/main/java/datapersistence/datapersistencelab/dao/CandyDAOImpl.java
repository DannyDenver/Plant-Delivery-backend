package datapersistence.datapersistencelab.dao;

import datapersistence.datapersistencelab.entity.Delivery;
import datapersistence.datapersistencelab.model.CandyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CandyDAOImpl implements CandyDAO {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    private static final String SELECT_ALL_CANDY = "Select * FROM CANDY";
    private static final String FIND_BY_DELIVERY_ID = "SELECT * FROM DELIVERY WHERE id = :id";

    private static final String INSERT_DELIVERY =
            "INSERT INTO candy_delivery (candy_id, delivery_id) " +
                    "VALUES (:" + CANDY_ID + ", :" + DELIVERY_ID + ")";

    private static final String FIND_CANDY_BY_DELIVERY =
            "Select * from candy c " +
            "JOIN candy_delivery cd " +
            "on cd.candy_id = c.id " +
            "where cd.delivery_id = :deliveryId";

    private static final RowMapper<CandyData> candyDataRowMapper =
            new BeanPropertyRowMapper<>(CandyData.class);

    @Override
    public List<CandyData> list() {
        return jdbcTemplate.query(
                SELECT_ALL_CANDY,
                candyDataRowMapper);
        );
    }

    @Override
    public void addToDelivery(Long candyId, Long deliveryid) {
        jdbcTemplate.update(INSERT_DELIVERY,
                new MapSqlParameterSource()
                        .addValue(CANDY_ID, candyId)
                        .addValue(DELIVERY_ID, deliveryid));
    }

    @Override
    public List<CandyData> findByDelivery(Long deliveryid) {
        return jdbcTemplate.query(FIND_CANDY_BY_DELIVERY,
                    new MapSqlParameterSource("deliveryId", deliveryid),
                candyDataRowMapper
                );
    }
}
