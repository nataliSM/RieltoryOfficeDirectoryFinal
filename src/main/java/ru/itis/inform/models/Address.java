package ru.itis.inform.models;

import javax.persistence.*;

/**
 * Created by Natalia on 05.11.16.
 */

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_address" )
    private Integer id;

    @Column
    private Integer house;
    @Column
    private Integer flat;


    @ManyToOne(targetEntity = City.class, fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn (name = "city_id")
    private  City city;



    @ManyToOne (targetEntity = Street.class, fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn (name = "street_id")
    private  Street street;



    public Address(int address_id, int flat, int house) {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


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
