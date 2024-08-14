package project.java.app.model;

import java.security.Timestamp;

// import project.User;

public class Partner {
    private long Id;
    private User userId;
    private double money;
    private String type;
    // crear una variable de nombre dateCreated de tipo timestamp
    private Timestamp dateCreated;

    public Partner() {
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

}