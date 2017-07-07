package com.exercise.models;

import javax.persistence.*;

/**
 * Created by Ibukun.Ogunsolu on 7/1/2017.
 */
@Entity
@Table(name="subject",uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
public class Subject {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", nullable=false, unique=true, length=11)
    private int id;
    @Column(name="code", length=200, nullable=true)
    private String code;
    @Column(name="name", length=200, nullable=true)
    private String name;
    @Column(name="description", length=200, nullable=true)
    private String description;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
