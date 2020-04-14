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
        if (!(o instanceof Developer)) return false;

        Developer developer = (Developer) o;

        if (getId() != developer.getId()) return false;
        if (getFirstName() != null ? !getFirstName().equals(developer.getFirstName()) : developer.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(developer.getLastName()) : developer.getLastName() != null)
            return false;
        if (getSpecialty() != null ? !getSpecialty().equals(developer.getSpecialty()) : developer.getSpecialty() != null)
            return false;
        return getSkills() != null ? getSkills().equals(developer.getSkills()) : developer.getSkills() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getSpecialty() != null ? getSpecialty().hashCode() : 0);
        result = 31 * result + (getSkills() != null ? getSkills().hashCode() : 0);
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
