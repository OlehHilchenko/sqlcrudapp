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
        if (o == null || getClass() != o.getClass()) return false;

        Specialty specialty = (Specialty) o;

        if (id != specialty.id) return false;
        if (name != null ? !name.equals(specialty.name) : specialty.name != null) return false;
        return description != null ? description.equals(specialty.description) : specialty.description == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
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
