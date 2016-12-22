package ru.itis.inform.models.rieltoryModel;

/**
 * Created by Natalia on 05.11.16.
 */
public class City {
    private int id;
    private String name;

    public City(int id) {
        this.id = id;
    }

    public City(int cityID, String cityName) {
        this.id = cityID;
        this.name = cityName;
    }

    public City() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
