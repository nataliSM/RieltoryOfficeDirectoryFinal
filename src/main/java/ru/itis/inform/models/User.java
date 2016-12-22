package ru.itis.inform.models;



/**
 * Created by Natalia on 09.10.16.
 */
public class User  {

    private String name;
    private String password;
    private int id;
    private String token;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public String getToken() {
        return token;
    }
    public void setToken (String token) {
        this.token = token;
    }
}
