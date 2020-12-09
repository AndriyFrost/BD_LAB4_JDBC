package ua.lviv.iot.model.entity;

import ua.lviv.iot.model.annotation.Column;
import ua.lviv.iot.model.annotation.Id;
import ua.lviv.iot.model.annotation.Table;

import java.util.Objects;

@Table(name = "actor")
public class Actor {

    @Column(name = "acting_education")
    private Integer actingEducation;

    @Column(name = "biography")
    private String biography;

    @Id
    @Column(name = "manId")
    private Integer manId;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Actor actor = (Actor) o;
        return manId.equals(actor.manId)
                && actingEducation.equals(actor.actingEducation)
                && Objects.equals(biography, actor.biography);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actingEducation, biography, manId);
    }

    public Actor(Integer actingEducation, String biography, Integer manId) {
        this.actingEducation = actingEducation;
        this.biography = biography;
        this.manId = manId;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "actingEducation=" + actingEducation +
                ", biography='" + biography + '\'' +
                ", manId=" + manId +
                '}';
    }

    public Integer getActingEducation() {
        return actingEducation;
    }

    public void setActingEducation(Integer actingEducation) {
        this.actingEducation = actingEducation;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Integer getManId() {
        return manId;
    }

    public void setManId(Integer manId) {
        this.manId = manId;
    }
}
