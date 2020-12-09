package ua.lviv.iot.model.entity;

import ua.lviv.iot.model.annotation.Column;
import ua.lviv.iot.model.annotation.Id;
import ua.lviv.iot.model.annotation.Table;

import java.util.Objects;

@Table(name = "cinema")
public class Cinema {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    @Column(name = "country_id")
    private Integer countryId;

    @Override
    public String toString() {
        return "Cinema{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", countryId=" + countryId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Cinema(Integer id, String city, String address, Integer countryId) {
        this.id = id;
        this.city = city;
        this.address = address;
        this.countryId = countryId;
    }

    public Cinema(String city, String address, Integer countryId) {
        this(-1, city, address, countryId);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cinema cinema = (Cinema) o;
        return id.equals(cinema.id)
                && city.equals(cinema.city)
                && address.equals(cinema.address)
                && Objects.equals(countryId, cinema.countryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city, address, countryId);
    }
}
