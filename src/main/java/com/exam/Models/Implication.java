package com.exam.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Implication {

    @Id
    private Long id;
    private int percent;

    @OneToOne(mappedBy = "implications")
    private Employee e;
    @OneToOne(mappedBy="implications")
    private Project p;
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Implication() {
    }

    public Implication(Long id, int percent, Employee e, Project p) {
        this.id = id;
        this.percent = percent;
        this.e = e;
        this.p = p;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public Employee getE() {
        return e;
    }

    public void setE(Employee e) {
        this.e = e;
    }

    public Project getP() {
        return p;
    }

    public void setP(Project p) {
        this.p = p;
    }
}
