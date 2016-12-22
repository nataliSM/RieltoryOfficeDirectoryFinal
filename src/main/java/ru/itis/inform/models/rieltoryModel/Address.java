package ru.itis.inform.models.rieltoryModel;

/**
 * Created by Natalia on 05.11.16.
 */
public class Address {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer id;
    private City city;
    private Street street;
    private Integer house;
    private Integer flat;

    public Address(Integer id, City city, Street street, Integer house, Integer flat) {
        this.city = city;
        this.street = street;
        this.house = house;
        this.flat = flat;
    }

    public Address() {

    }

    public City getCity() {
        return city;
    }

    public Street getStreet() {
        return street;
    }

    public Integer getHouse() {
        return house;
    }

    public Integer getFlat() {
        return flat;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public void setHouse(Integer house) {
        this.house = house;
    }

    public void setFlat(Integer flat) {
        this.flat = flat;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city=" + city +
                ", street=" + street +
                ", house=" + house +
                ", flat=" + flat +
                '}';
    }
}
