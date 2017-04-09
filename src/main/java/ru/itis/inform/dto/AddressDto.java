package ru.itis.inform.dto;

import ru.itis.inform.models.City;
import ru.itis.inform.models.Street;

import javax.persistence.*;

/**
 * Created by Natalia on 09.04.17.
 */
public class AddressDto {
    private Integer id;
    private Integer house;
    private Integer flat;
    private  String cityName;
    private  String streetName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHouse() {
        return house;
    }

    public void setHouse(Integer house) {
        this.house = house;
    }

    public Integer getFlat() {
        return flat;
    }

    public void setFlat(Integer flat) {
        this.flat = flat;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
}
