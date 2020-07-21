package gr.codehub.crminnovative.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer  {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String address;
    private int age;
    private Date date;

    public Customer(String name){
        this.name=name;
    }

}
