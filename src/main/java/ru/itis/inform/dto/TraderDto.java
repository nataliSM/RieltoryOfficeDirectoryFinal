package ru.itis.inform.dto;

import javax.persistence.Column;

/**
 * Created by Natalia on 09.04.17.
 */
public class TraderDto {
    private Integer id;
    private String name;
    private String phoneNumber;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
