package datapersistence.datapersistencelab.entity;

import com.fasterxml.jackson.annotation.JsonView;
import datapersistence.datapersistencelab.service.PlantService;
import datapersistence.datapersistencelab.views.Views;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Plant {
    @Id
    @GeneratedValue
    private Long id;

    @JsonView(Views.Public.class)
    @Nationalized
    private String name;

    @JsonView(Views.Public.class)
    @Column(precision=12, scale=4)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name="delivery_id")
    private Delivery delivery;

}
