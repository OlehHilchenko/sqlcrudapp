package com.olehhilchenko.service;

        import com.olehhilchenko.model.Specialty;
        import com.olehhilchenko.repository.SpecialtyRepository;
        import com.olehhilchenko.repository.jdbc.JDBSSpecialtyRepositoryImpl;

public class SpecialtyService {
    private SpecialtyRepository specialtyRepository = new JDBSSpecialtyRepositoryImpl();

    public void add(Specialty specialty) {
        specialtyRepository.insert(specialty);
    }

    public void update(Specialty specialty) {
        specialtyRepository.update(specialty);
    }

    public Specialty get(Integer id) {
        return specialtyRepository.select(id);
    }

    public void remove(Specialty developer) {
        specialtyRepository.delete(developer);
    }
}
