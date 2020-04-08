package com.olehhilchenko.repository.hibernate;

import com.olehhilchenko.model.Developer;
import com.olehhilchenko.repository.DeveloperRepository;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class DeveloperDAO implements DeveloperRepository {

    @Override
    public void insert(Developer developer) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            session.save(developer);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Developer developer) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            session.saveOrUpdate(developer);
            session.getTransaction().commit();
        }
    }

    @Override
    public Developer select(Integer integer) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            Developer result = (Developer) session.load(Developer.class, integer);
            Hibernate.initialize(result.getSkills());
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public void delete(Developer developer) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            session.delete(developer);
            session.getTransaction().commit();
        }
    }

    public List<Developer> getDeveloperList() {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            List<Developer> result = session.createQuery("FROM Developer").list();
            for (Developer developer : result) {
                Hibernate.initialize(developer.getSkills());
            }
            session.getTransaction().commit();
            return result;
        }
    }
}
