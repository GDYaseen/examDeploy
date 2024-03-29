package com.exam.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Project {
    @Id
    private Long id;
    private String name;
    private double budget;

    @ManyToOne
    private List<Implication> implications = new ArrayList<>();
    public void setId(Long id) {
        this.id = id;
    }

    public Project() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public List<Implication> getCharges() {
        return implications;
    }

    public void setCharges(List<Implication> implications) {
        this.implications = implications;
    }

    public Project(Long id, String name, double budget, List<Implication> implications) {
        this.id = id;
        this.name = name;
        this.budget = budget;
        this.implications = implications;
    }

    public Long getId() {
        return id;
    }
}
