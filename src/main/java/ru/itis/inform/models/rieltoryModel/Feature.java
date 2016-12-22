package ru.itis.inform.models.rieltoryModel;

/**
 * Created by Natalia on 05.11.16.
 */
public class Feature {
    private Integer id;
    private Integer countOfRoom;
    private String condition;
    private String repair;

    public Feature(Integer id, Integer countOfRoom, String condition, String repair) {
        this.id = id;
        this.countOfRoom = countOfRoom;
        this.condition = condition;
        this.repair = repair;
    }

    public Feature() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCountOfRoom() {
        return countOfRoom;
    }

    public void setCountOfRoom(Integer countOfRoom) {
        this.countOfRoom = countOfRoom;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getRepair() {
        return repair;
    }

    public void setRepair(String repair) {
        this.repair = repair;
    }

    @Override
    public String toString() {
        return "Feature{" +
                "id=" + id +
                ", countOfRoom=" + countOfRoom +
                ", condition='" + condition + '\'' +
                ", repair='" + repair + '\'' +
                '}';
    }
}
