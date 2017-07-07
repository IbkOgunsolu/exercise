package com.exercise.models;

import javax.persistence.*;

/**
 * Created by Ibukun.Ogunsolu on 7/1/2017.
 */
@Entity
@Table(name="application",uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
public class Application {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", nullable=false, unique=true, length=11)
    private int id;
    @ManyToOne(cascade = CascadeType.ALL)
    private Student student;
    @Column(name="application_status", length=200, nullable=true)
    private ApplicationStatus status;
    @Column(name="statement_of_purpose", length=2000, nullable=true)
    private String statementOfPurpose;

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

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    public String getStatementOfPurpose() {
        return statementOfPurpose;
    }

    public void setStatementOfPurpose(String statementOfPurpose) {
        this.statementOfPurpose = statementOfPurpose;
    }
}
