package gr.codehub.crminnovative.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Orders {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private Date ordersDate;
    private double totalAmount;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "orders")
    @JsonIgnore
    private List<OrderProduct> orderProducts;

    @ManyToOne
    private Customer customer;

}
