package com.exam.DAO;

import com.exam.Models.Implication;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@Named
@RequestScoped
public class ImplicationBean {

    private EntityManagerFactory emf;
    private EntityManager em;

    public ImplicationBean() {
        emf = Persistence.createEntityManagerFactory("myDatabase");
        em = emf.createEntityManager();
    }

    public void create(Implication s) {
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
    }

    public Implication find(int id) {
        return em.find(Implication.class, id);
    }

    public void update(Implication s) {
        em.getTransaction().begin();
        em.merge(s);
        em.getTransaction().commit();
    }

    public void delete(int id) {
        Implication s = find(id);
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
