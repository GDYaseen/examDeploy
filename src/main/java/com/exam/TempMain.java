package com.exam;

import com.exam.DAO.EmployeeBean;
import com.exam.Models.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TempMain {

    public static void main(String[] args) {
         EntityManagerFactory emf;
         EntityManager em;
        emf = Persistence.createEntityManagerFactory("myDatabase");
        em = emf.createEntityManager();
        EmployeeBean bean =  new EmployeeBean();

        Employee e = new Employee();
        em.createNamedQuery("Employee.findAll").getResultList().forEach(System.out::println);;
    }
}
