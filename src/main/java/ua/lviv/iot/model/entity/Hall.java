package ua.lviv.iot.model.entity;

import ua.lviv.iot.model.annotation.Column;
import ua.lviv.iot.model.annotation.Id;
import ua.lviv.iot.model.annotation.Table;

import java.util.Objects;

@Table(name = "hall")
public class Hall {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "number_of_seats")
    private Integer numberOfSeats;

    @Column(name = "cinema_id")
    private Integer cinemaId;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Hall hall = (Hall) o;
        return id.equals(hall.id)
                && numberOfSeats.equals(hall.numberOfSeats)
                && cinemaId.equals(hall.cinemaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numberOfSeats, cinemaId);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Integer getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Integer cinemaId) {
        this.cinemaId = cinemaId;
    }

    public Hall(Integer id, Integer numberOfSeats, Integer cinemaId) {
        this.id = id;
        this.numberOfSeats = numberOfSeats;
        this.cinemaId = cinemaId;
    }

    public Hall(Integer numberOfSeats, Integer cinemaId) {
        this(-1, numberOfSeats, cinemaId);
    }

    @Override
    public String toString() {
        return "Hall{" +
                "id=" + id +
                ", numberOfSeats=" + numberOfSeats +
                ", cinemaId=" + cinemaId +
                '}';
    }
}
