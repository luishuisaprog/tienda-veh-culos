package com.example.VehicleShop.objects;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SportsCarCSVObject {
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

    @CsvBindByName(column = "topSpeed")
    private int topSpeed;

    @CsvBindByName(column = "bodyType")
    private String bodyType;

    @CsvBindByName(column = "exhaustType")
    private String exhaustType;

    @CsvBindByName(column = "dragRaceTime")
    private int dragRaceTime;
}
