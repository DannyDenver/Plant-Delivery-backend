package datapersistence.datapersistencelab.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="shrub")
public class Shrub {
    private int height;
    private int width;

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
