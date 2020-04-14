package com.olehhilchenko.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "skills")
public class Skill {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @ManyToMany(mappedBy = "skills")
    private List<Developer> developer;

    public Skill() {
    }

    public Skill(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Skill(int id, String name, List<Developer> developer) {
        this.id = id;
        this.name = name;
        this.developer = developer;
    }

    public List<Developer> getDeveloper() {
        return developer;
    }

    public void setDeveloper(List<Developer> developer) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Skill)) return false;

        Skill skill = (Skill) o;

        if (getId() != skill.getId()) return false;
        return getName() != null ? getName().equals(skill.getName()) : skill.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
