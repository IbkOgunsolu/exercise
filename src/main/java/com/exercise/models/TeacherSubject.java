package com.exercise.models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Ibukun.Ogunsolu on 7/2/2017.
 */
@Entity
@Table(name="teacher_subject",uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
public class TeacherSubject {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", nullable=false, unique=true, length=11)
    private int id;
    @ManyToOne(cascade = CascadeType.ALL)
    private Teacher teacher;
    @ManyToOne(cascade = CascadeType.ALL)
    private Subject subject;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
