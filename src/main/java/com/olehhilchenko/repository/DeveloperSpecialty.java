package com.olehhilchenko.repository;

public class DeveloperSpecialty {

    private int developerId;
    private int specialtyId;

    public DeveloperSpecialty() {
    }

    public DeveloperSpecialty(int developerId, int specialtyId) {
        this.developerId = developerId;
        this.specialtyId = specialtyId;
    }

    public int getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(int developerId) {
        this.developerId = developerId;
    }

    public int getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(int specialtyId) {
        this.specialtyId = specialtyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeveloperSpecialty that = (DeveloperSpecialty) o;

        if (developerId != that.developerId) return false;
        return specialtyId == that.specialtyId;
    }

    @Override
    public int hashCode() {
        int result = developerId;
        result = 31 * result + specialtyId;
        return result;
    }

    @Override
    public String toString() {
        return "DeveloperSpecialty{" +
                "developerId=" + developerId +
                ", specialtyId=" + specialtyId +
                '}';
    }
}
