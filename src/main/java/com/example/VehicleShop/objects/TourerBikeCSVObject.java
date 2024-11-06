package com.example.VehicleShop.objects;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TourerBikeCSVObject {
    @CsvBindByName(column = "brand")
    protected String brand;

    @CsvBindByName(column = "model")
    protected String model;

    @CsvBindByName(column = "engineDisplacement")
    protected int engineDisplacement;

    @CsvBindByName(column = "tankCapacity")
    private Integer tankCapacity;

}
