package com.spring.mvc.architect.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "entity")
@Component
public class myEntity {
    @Column(name = "nameEntity")
    private String nameEntity;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    public void setNameEntity(String nameEntity) {
        this.nameEntity = nameEntity;
    }

    public String getNameEntity() {
        return nameEntity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public myEntity() {
    }

    public myEntity(String nameEntity, int id) {
        this.nameEntity = nameEntity;
        this.id = id;
    }
}
