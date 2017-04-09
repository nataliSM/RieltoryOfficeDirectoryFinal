package ru.itis.inform.models;

import javax.persistence.*;

/**
 * Created by Natalia on 05.11.16.
 */
@Entity
@Table (name= "street")
public class Street {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "street_id" )
    private Integer id;


    @ManyToOne(targetEntity = City.class,fetch = FetchType.EAGER)
    @JoinColumn (name = "city_id")
    private City city;

    @Column (name = "street_name")
    private String name;

    public Street(Integer id, String streetName, City city) {
        this.id =id;
        this.city = city;
        this.name = streetName;
    }

    public Street() {

    }

    public Street(int id) {
        this.id = id;
    }

    public Street(int street_id, City city, String street_name) {

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Street{" +
                "id=" + id +
                ", city=" + city +
                ", name='" + name + '\'' +
                '}';
    }
}
