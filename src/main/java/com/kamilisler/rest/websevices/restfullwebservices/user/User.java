package com.kamilisler.rest.websevices.restfullwebservices.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class User {
    @Id
    private Integer id;
    @Size(min = 3, message = "İsim en az 3 harfli olmalı !")
    private String name;
    @Past
    private Date birth;

    public User(Integer id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birth = birthDate;
    }

    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birth +
                '}';
    }

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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birthDate) {
        this.birth = birthDate;
    }
}
