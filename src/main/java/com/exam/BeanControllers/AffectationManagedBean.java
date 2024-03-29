package com.exam.BeanControllers;

import com.exam.DAO.ImplicationBean;
import com.exam.Models.Employee;
import com.exam.Models.Implication;
import com.exam.Models.Project;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class AffectationManagedBean {

    private ImplicationBean implicBean = new ImplicationBean();

    private Employee employee;
    private Project project;
    private String charge;

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public void setProjectsToEmpl(){
        Implication i = new Implication();
        i.setE(employee);
        i.setP(project);
        implicBean.create(i);
    }
    public AffectationManagedBean() {
    }

    public AffectationManagedBean(ImplicationBean implicBean, Employee employee, Project project) {
        this.implicBean = implicBean;
        this.employee = employee;
        this.project = project;
    }

    public ImplicationBean getImplicBean() {
        return implicBean;
    }

    public void setImplicBean(ImplicationBean implicBean) {
        this.implicBean = implicBean;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
