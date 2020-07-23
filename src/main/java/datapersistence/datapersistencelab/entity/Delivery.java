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
    private boolean completed;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "delivery", cascade = CascadeType.ALL)
    List<Plant> plants;

    public Delivery(String name, String address, LocalDateTime deliveryDate) {
        this.name = name;
        this.address = address;
        this.deliveryDate = deliveryDate;
    }

    public Delivery() { }

    /* getters and setters */

    public Long getId() {
        return this.id;
    }

    public List<Plant> getPlants() {
        return this.plants;
    }
    public void setPlants(List<Plant> plants) { this.plants = plants; };

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

}
