package com.nanda.vo;

public class Fans {
    private int id;
    private int userId;
    private int idolId;
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getIdolId() {
        return idolId;
    }

    public void setIdolId(int idolId) {
        this.idolId = idolId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
