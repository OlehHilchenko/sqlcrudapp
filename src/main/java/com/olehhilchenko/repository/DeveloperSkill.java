package com.olehhilchenko.repository;

public class DeveloperSkill {

    private int developerId;
    private int skillId;

    public DeveloperSkill() {
    }

    public DeveloperSkill(int developerId, int skillId) {
        this.developerId = developerId;
        this.skillId = skillId;
    }

    public int getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(int developerId) {
        this.developerId = developerId;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeveloperSkill that = (DeveloperSkill) o;

        if (developerId != that.developerId) return false;
        return skillId == that.skillId;
    }

    @Override
    public int hashCode() {
        int result = developerId;
        result = 31 * result + skillId;
        return result;
    }

    @Override
    public String toString() {
        return "DeveloperSkill{" +
                "developerId=" + developerId +
                ", skillId=" + skillId +
                '}';
    }
}