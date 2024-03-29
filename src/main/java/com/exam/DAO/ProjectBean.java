package com.exam.DAO;

import com.exam.Models.Project;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.*;

@Named
@RequestScoped
public class ProjectBean {

    private EntityManagerFactory emf;
    private EntityManager em;

    public ProjectBean() {
        emf = Persistence.createEntityManagerFactory("myDatabase");
        em = emf.createEntityManager();
    }

    public void create(Project s) {
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
    }

    public Project find(int id) {
        return em.find(Project.class, id);
    }

    public void update(Project s) {
        em.getTransaction().begin();
        em.merge(s);
        em.getTransaction().commit();
    }

    public void delete(int id) {
        Project s = find(id);
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
