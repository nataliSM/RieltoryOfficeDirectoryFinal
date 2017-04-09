package ru.itis.inform.dto;

import javax.persistence.Column;

/**
 * Created by Natalia on 09.04.17.
 */
public class FeatureDto {
    private Integer id;
    private Integer countOfRoom;
    private String condition;
    private String repair;

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
}
