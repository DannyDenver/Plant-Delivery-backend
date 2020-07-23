package datapersistence.datapersistencelab.entity;

import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Flower extends Plant {

    private String color;

    public Flower(String name, Long price) {
        super(name, price);
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }
}
