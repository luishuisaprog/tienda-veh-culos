package com.example.VehicleShop.objects;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LuxuryCarCSVObject {


    @CsvBindByName(column = "brand")
    private String brand;

    @CsvBindByName(column = "model")
    private String model;

    @CsvBindByName(column = "fuelType")
    private String fuelType;

    @CsvBindByName(column = "productionYear")
    private String productionYear;

    @CsvBindByName(column = "price")
    private int price;

    @CsvBindByName(column = "features")
    private String features;

    @CsvBindByName(column = "massageSeats")
    private String massageSeats;


}
