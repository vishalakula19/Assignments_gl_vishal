package org.gl.entity;

import jakarta.persistence.*;

@Entity(name="Teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="firstName")
    private String f_Name;
    @Column(name="lastName")
    private String l_Name;
    private String email;

    public Teacher() {
    }

    public Teacher(String f_Name, String l_Name, String email) {
        this.f_Name = f_Name;
        this.l_Name = l_Name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getF_Name() {
        return f_Name;
    }

    public void setF_Name(String f_Name) {
        this.f_Name = f_Name;
    }

    public String getL_Name() {
        return l_Name;
    }

    public void setL_Name(String l_Name) {
        this.l_Name = l_Name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
