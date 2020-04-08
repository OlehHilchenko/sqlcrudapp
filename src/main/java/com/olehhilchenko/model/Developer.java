package com.olehhilchenko.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "developer")
public class Developer {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "developer_specialty",
            joinColumns =
                    {@JoinColumn(name = "developer_id", referencedColumnName = "id")},
            inverseJoinColumns =
                    {@JoinColumn(name = "specialty_id", referencedColumnName = "id")})
    private Specialty specialty;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "developer_skills",
            joinColumns =
                    {@JoinColumn(name = "developer_id", referencedColumnName = "id")},
            inverseJoinColumns =
                    {@JoinColumn(name = "skill_id", referencedColumnName = "id")})
    private List<Skill> skills;

    public Developer() {
    }

    public Developer(int id, String firstName, String lastName, Specialty specialty, List<Skill> skills) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
        this.skills = skills;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Developer developer = (Developer) o;

        if (id != developer.id) return false;
        if (firstName != null ? !firstName.equals(developer.firstName) : developer.firstName != null) return false;
        if (lastName != null ? !lastName.equals(developer.lastName) : developer.lastName != null) return false;
        if (specialty != null ? !specialty.equals(developer.specialty) : developer.specialty != null) return false;
        return skills != null ? skills.equals(developer.skills) : developer.skills == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (specialty != null ? specialty.hashCode() : 0);
        result = 31 * result + (skills != null ? skills.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", specialty=" + specialty +
                ", skills=" + skills +
                '}';
    }
}
