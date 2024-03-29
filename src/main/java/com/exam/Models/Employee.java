package com.exam.Models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name = "Employee.findAll" ,query = "Select * from employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name,email;
    private List<String> skills = new ArrayList<String>();


    @OneToMany(mappedBy = "e")
    private List<Implication> implications =new ArrayList<Implication>();
    public Employee(Long id) {
        this.id = id;
    }

    public Employee() {
    }

    public List<Implication> getCharges() {
        return implications;
    }

    public void setCharges(List<Implication> implications) {
        this.implications = implications;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }
}
