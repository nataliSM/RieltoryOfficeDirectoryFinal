package ru.itis.inform.DAOs;

public enum Database {
    ApplicationDatabase , RieltoryDatabase;


    private String urlString;
    private String user;
    private String password;
    private String driver;


    static {
        ApplicationDatabase.urlString = "jdbc:postgresql://127.0.0.1:5432/appdb";
        ApplicationDatabase.user = "Natalia";
        ApplicationDatabase.password = "";
        ApplicationDatabase.driver = "org.postgresql.Driver";

        RieltoryDatabase.urlString = "jdbc:postgresql://127.0.0.1:5432/rieltoryofficetest";
        RieltoryDatabase.user = "Natalia";
        RieltoryDatabase.password = "";
        RieltoryDatabase.driver = "org.postgresql.Driver";


    }

    public String getUrlString() {
        return urlString;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getDriver() {
        return driver;
    }
}

