package datapersistence.datapersistencelab.entity;


import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@NamedQuery(
        name = "Delivery.findByName",
        query = "select d from Delivery d where d.name = :name"
)

@Entity
public class Delivery {
    @Id
    @GeneratedValue
    private Long id;

    @Nationalized
    private String name;

    @Column(name="address_full", length=500)
    private String address;

    private LocalDateTime deliveryDate;
    @Type(type="yes_no")
    private Character completed;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "delivery", cascade = CascadeType.ALL)
    List<Plant> plants;

    /* getters and setters */

    public Long getId() {
        return this.id;
    }

    public List<Plant> getPlants() {
        return this.plants;
    }

}
