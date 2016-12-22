package ru.itis.inform.models.rieltoryModel;

/**
 * Created by Natalia on 05.11.16.
 */
public class Street {
    private Integer id;
    private City city;
    private String name;

    public Street(Integer streetId, String streetName, City city) {
        this.id =streetId;
        this.city = city;
        this.name = streetName;
    }

    public Street() {

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
