package com.imbilalbutt.Spring.MVC.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class User extends DistributedEntity {

    @Column(name="USER_NAME", nullable = false)
    private String username;

    @Column(name="NAME")
    private String name;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
