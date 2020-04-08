package com.olehhilchenko.service;

import com.olehhilchenko.model.Developer;
import com.olehhilchenko.repository.DeveloperRepository;
import com.olehhilchenko.repository.hibernate.DeveloperDAO;
import com.olehhilchenko.repository.hibernate.HibernateUtil;

import java.util.List;

/**
 * This class is repository layer, it stores developer-type objects in a mysql database;
 * Supports basic operations:
 * insert
 * update
 * select
 * delete
 *
 * @author Oleg Gilchenko
 * @version 1.0
 */

public class DeveloperService {

    private DeveloperRepository developerRepository = new DeveloperDAO();

    public void add(Developer developer) {
        developerRepository.insert(developer);
    }

    public void update(Developer developer) {
        developerRepository.update(developer);
    }

    public Developer get(Integer id) {
        return developerRepository.select(id);
    }

    public void remove(Developer developer) {
        developerRepository.delete(developer);
    }

    public List<Developer> getDeveloperList() {
        return developerRepository.getDeveloperList();
    }

    public Integer nextId() {
        return HibernateUtil.getNextID();
    }
}
