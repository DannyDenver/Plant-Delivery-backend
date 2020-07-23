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
    @Column(precision = 12, scale = 4)
    private BigDecimal price;

    //don't retrieve delivery if we don't need it
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    // Convenience Constructor
    public Plant(String name, double price) {
        this.name = name;
        this.price = BigDecimal.valueOf(price);
    }

    public Plant() {
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public Long getId() {
        return id;
    }
}