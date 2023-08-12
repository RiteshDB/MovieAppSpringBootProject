package com.upgrad.MovieApp.Entities;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class City {

    public City(){

    }
    public City(int cityId, String cityName, Set<Theater> theaters) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.theaters = theaters;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cityId;

    @Column(name = "city_name", nullable = false)
    private String cityName;

    @OneToMany(mappedBy = "city")
    private Set<Theater> theaters;

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Set<Theater> getTheaters() {
        return theaters;
    }

    public void setTheaters(Set<Theater> theaters) {
        this.theaters = theaters;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", theaters=" + theaters +
                '}';
    }
}
