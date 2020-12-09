package ua.lviv.iot.model.entity;

import ua.lviv.iot.model.annotation.Column;
import ua.lviv.iot.model.annotation.Id;
import ua.lviv.iot.model.annotation.Table;

import java.util.Objects;

@Table(name = "film_has_actor")
public class FilmHasActor {

    @Id
    @Column(name = "film_id")
    private Integer filmId;

    @Id
    @Column(name = "actor_id")
    private Integer actorId;

    public FilmHasActor() {

    }

    public FilmHasActor(Integer filmId, Integer actorId) {
        this.filmId = filmId;
        this.actorId = actorId;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FilmHasActor filmHasActor = (FilmHasActor) o;
        return filmId.equals(filmHasActor.filmId)
                && actorId.equals(filmHasActor.actorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmId, actorId);
    }

    @Override
    public String toString() {
        return "FilmHasActor{" +
                "filmId=" + filmId +
                ", actorId=" + actorId +
                '}';
    }
}
