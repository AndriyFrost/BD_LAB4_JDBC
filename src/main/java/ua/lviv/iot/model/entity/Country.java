package ua.lviv.iot.model.entity;

import ua.lviv.iot.model.annotation.Column;
import ua.lviv.iot.model.annotation.Id;
import ua.lviv.iot.model.annotation.Table;

import java.util.Objects;

@Table(name = "country")
public class Country {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "capital")
    private String capital;

    @Column(name = "population")
    private Integer population;

    @Column(name = "area_in_sk")
    private Double areaInSk;

    @Column(name = "country_name")
    private String countryName;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Country country = (Country) o;
        return id.equals(country.id)
                && capital.equals(country.capital)
                && population.equals(country.population)
                && Objects.equals(areaInSk, country.areaInSk)
                && Objects.equals(countryName, country.countryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, capital, population, areaInSk,countryName);
    }

    public Country(Integer id, String capital, Integer population, Double areaInSk, String countryName) {
        this.id = id;
        this.capital = capital;
        this.population = population;
        this.areaInSk = areaInSk;
        this.countryName = countryName;
    }
    public Country( String capital, Integer population, Double areaInSk, String countryName) {
        this(-1,capital,population,areaInSk,countryName);
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", capital='" + capital + '\'' +
                ", population=" + population +
                ", areaInSk=" + areaInSk +
                ", countryName='" + countryName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Double getAreaInSk() {
        return areaInSk;
    }

    public void setAreaInSk(Double areaInSk) {
        this.areaInSk = areaInSk;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
