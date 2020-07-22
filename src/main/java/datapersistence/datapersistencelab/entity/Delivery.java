package datapersistence.datapersistencelab.entity;


import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
public class Delivery {
    @Id
    @GeneratedValue
    private Long id;

    @Nationalized
    private String recipientName;

    @Column(name="address_full", length=500)
    private String address;

    private LocalDateTime deliveryDate;
    @Type(type="yes_no")
    private Character completed;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "delivery")
    List<Plant> list;
}
