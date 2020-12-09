package ua.lviv.iot.model.entity;

import ua.lviv.iot.model.annotation.Column;
import ua.lviv.iot.model.annotation.Id;
import ua.lviv.iot.model.annotation.Table;

import java.util.Objects;

@Table(name = "review")
public class Review {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "response")
    private String response;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "recommended")
    private Integer recommended;

    @Column(name = "man_id")
    private Integer manId;

    @Column(name = "film_id")
    private Integer filmId;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Review review = (Review) o;
        return id.equals(review.id)
                && response.equals(review.response)
                && rating.equals(review.rating)
                && Objects.equals(recommended, review.recommended)
                && Objects.equals(manId, review.manId)
                && Objects.equals(filmId, review.filmId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, response, rating, recommended, manId, filmId);
    }

    public Review(Integer id, String response, Integer rating, Integer recommended, Integer manId, Integer filmId) {
        this.id = id;
        this.response = response;
        this.rating = rating;
        this.recommended = recommended;
        this.manId = manId;
        this.filmId = filmId;
    }

    public Review(String response, Integer rating, Integer recommended, Integer manId, Integer filmId) {
        this(-1, response, rating, recommended, manId, filmId);
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", response='" + response + '\'' +
                ", rating=" + rating +
                ", recommended=" + recommended +
                ", manId=" + manId +
                ", filmId=" + filmId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getRecommended() {
        return recommended;
    }

    public void setRecommended(Integer recommended) {
        this.recommended = recommended;
    }

    public Integer getManId() {
        return manId;
    }

    public void setManId(Integer manId) {
        this.manId = manId;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }
}
