package com.exam.DAO;

import com.exam.Models.Employee;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class EmployeeBean {

    private EntityManagerFactory emf;
    private EntityManager em;

    public EmployeeBean() {
        emf = Persistence.createEntityManagerFactory("myDatabase");
        em = emf.createEntityManager();
    }

    public void create(Employee s) {
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
    }

    public Employee find(int id) {
        return em.find(Employee.class, id);
    }

    public List<Employee> getAll(){
        em.getTransaction().begin();
        ArrayList<Employee> list = (ArrayList<Employee>)em.createNamedQuery("Employee.findAll").getResultList();
        em.getTransaction().commit();
        return list;
    }
    public void update(Employee s) {
        em.getTransaction().begin();
        em.merge(s);
        em.getTransaction().commit();
    }

    public void delete(int id) {
        Employee s = find(id);
        if (s != null) {
            em.getTransaction().begin();
            em.remove(s);
            em.getTransaction().commit();
        }
    }

    // Call this method to close the EntityManager and its factory when done using this bean.
    public void close() {
        if (em != null) {
            em.close();
        }
        if (emf != null) {
            emf.close();
        }
    }
}
