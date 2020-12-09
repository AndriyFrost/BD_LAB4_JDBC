package ua.lviv.iot.model.entity;

import ua.lviv.iot.model.annotation.Column;
import ua.lviv.iot.model.annotation.Id;
import ua.lviv.iot.model.annotation.Table;

import java.time.LocalDateTime;
import java.util.Objects;

@Table(name = "session")
public class Session {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "event_time")
    private String eventTime;

    @Column(name = "ticket_price")
    private Integer ticketPrice;

    @Column(name = "ticket_sold")
    private Integer ticketSold;

    @Column(name = "film_id")
    private Integer filmId;

    @Column(name = "hall_id")
    private Integer hallId;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Session session = (Session) o;
        return id.equals(session.id)
                && eventTime.equals(session.eventTime)
                && ticketPrice.equals(session.ticketPrice)
                && ticketSold.equals(session.ticketSold)
                && filmId.equals(session.filmId)
                && hallId.equals(session.hallId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eventTime, ticketPrice, ticketSold, filmId, hallId);
    }

    public Session(Integer id, String eventTime, Integer ticketPrice, Integer ticketSold, Integer filmId, Integer hallId) {
        this.id = id;
        this.eventTime = eventTime;
        this.ticketPrice = ticketPrice;
        this.ticketSold = ticketSold;
        this.filmId = filmId;
        this.hallId = hallId;
    }

    public Session(String eventTime, Integer ticketPrice, Integer ticketSold, Integer filmId, Integer hallId) {
        this(-1, eventTime, ticketPrice, ticketSold, filmId, hallId);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public Integer getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Integer ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Integer getTicketSold() {
        return ticketSold;
    }

    public void setTicketSold(Integer ticketSold) {
        this.ticketSold = ticketSold;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public Integer getHallId() {
        return hallId;
    }

    public void setHallId(Integer hallId) {
        this.hallId = hallId;
    }

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", eventTime=" + eventTime +
                ", ticketPrice=" + ticketPrice +
                ", ticketSold=" + ticketSold +
                ", filmId=" + filmId +
                ", hallId=" + hallId +
                '}';
    }
}
