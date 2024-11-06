package com.example.VehicleShop.entity;

import lombok.*;

import javax.persistence.*;
import java.awt.print.Book;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@MappedSuperclass
public class Cars {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;

    private String model;

    private String fuelType;

    private String productionYear;

    private int price;



    public Cars(String brand, String model, String fuelType, String productionYear, int price) {
        this.brand = brand;
        this.model = model;
        this.fuelType = fuelType;
        this.productionYear = productionYear;
        this.price = price;
    }
}
