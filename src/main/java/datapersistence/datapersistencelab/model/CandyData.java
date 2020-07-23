package datapersistence.datapersistencelab.model;

import java.math.BigDecimal;

public class CandyData {
    private Long id;
    private String name;
    private BigDecimal price;

    public Long getId() {return id;};
    public void setName(String name) {this.name = name;};
    public String getName() { return name;};
    public void setPrice(BigDecimal price){this.price = price;};
    public BigDecimal getPrice() { return price;}
}
