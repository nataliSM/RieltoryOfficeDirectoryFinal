package ru.itis.inform.models;
import javax.persistence.*;
import javax.persistence.Entity;

/**
 * Created by Natalia on 05.11.16.
 */
@Entity
@Table (name = "features")
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "features_id")
    private Integer id;
    @Column (name = "count_of_room")
    private Integer countOfRoom;
    @Column
    private String condition;
    @Column
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
