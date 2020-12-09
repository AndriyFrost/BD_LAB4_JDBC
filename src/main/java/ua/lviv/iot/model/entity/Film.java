package ua.lviv.iot.model.entity;

import ua.lviv.iot.model.annotation.Column;
import ua.lviv.iot.model.annotation.Id;
import ua.lviv.iot.model.annotation.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Table(name = "film")
public class Film {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "move_title")
    private String moveTitle;

    @Column(name = "genre")
    private String genre;

    @Column(name = "description")
    private String description;

    @Column(name = "release_date")
    private String releaseDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Film film = (Film) o;
        return id.equals(film.id)
                && moveTitle.equals(film.moveTitle)
                && genre.equals(film.genre)
                && Objects.equals(description, film.description)
                && Objects.equals(releaseDate, film.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, moveTitle, genre, description,releaseDate);
    }

    public Film(Integer id, String moveTitle, String genre, String description, String releaseDate) {
        this.id = id;
        this.moveTitle = moveTitle;
        this.genre = genre;
        this.description = description;
        this.releaseDate = releaseDate;
    }
    public Film(String moveTitle, String genre, String description, String releaseDate) {
        this(-1,moveTitle,genre,description,releaseDate);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMoveTitle() {
        return moveTitle;
    }

    public void setMoveTitle(String moveTitle) {
        this.moveTitle = moveTitle;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "film{" +
                "id=" + id +
                ", moveTitle='" + moveTitle + '\'' +
                ", genre='" + genre + '\'' +
                ", description='" + description + '\'' +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
