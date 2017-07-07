package com.exercise.models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Ibukun.Ogunsolu on 7/2/2017.
 */
@Entity
@Table(name="student_subject",uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
public class StudentSubject{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", nullable=false, unique=true, length=11)
    private int id;
    @ManyToOne(cascade = CascadeType.ALL)
    private Student student;
    @ManyToOne(cascade = CascadeType.ALL)
    private Subject subject;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
