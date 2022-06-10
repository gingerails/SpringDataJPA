package com.genpt.springdatajpa.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class Items {
    @Id
    private int ID;
    private String description;
    private String brand;
    private double price;
}
