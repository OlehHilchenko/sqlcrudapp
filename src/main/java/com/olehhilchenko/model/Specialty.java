package com.olehhilchenko.model;

import javax.persistence.*;

@Entity
@Table(name = "specialty")
public class Specialty {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    @OneToOne(mappedBy = "specialty")
    private Developer developer;

    public Specialty() {
    }

    public Specialty(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Specialty(int id, String name, String description, Developer developer) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.developer = developer;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Specialty)) return false;

        Specialty specialty = (Specialty) o;

        if (getId() != specialty.getId()) return false;
        if (getName() != null ? !getName().equals(specialty.getName()) : specialty.getName() != null) return false;
        return getDescription() != null ? getDescription().equals(specialty.getDescription()) : specialty.getDescription() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Specialty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
