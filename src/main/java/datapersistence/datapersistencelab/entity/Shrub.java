package datapersistence.datapersistencelab.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
public class Shrub extends Plant {
    private int height;
    private int width;

    public Shrub(String name, Long price) {
        super(name, price);
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return this.height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return this.width;
    }
}
