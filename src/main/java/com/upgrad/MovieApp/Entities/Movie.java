package com.upgrad.MovieApp.Entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "movieDB")
public class Movie {

    public Movie(){

    }
    public Movie( String movieName, String description, LocalDateTime releaseDate, int duration, String coverPhotoUrl, String trailerURL) {
        this.movieName = movieName;
        this.description = description;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.coverPhotoUrl = coverPhotoUrl;
        this.trailerURL = trailerURL;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int movieId;

    @Column(name="movie_name", nullable = false, length = 50)
    private String movieName;

    @Column(nullable = false,length = 500)
    private String description;

    @Column(nullable = false)
    private LocalDateTime releaseDate;

    @Column(nullable = false)
    private int duration;

    @Column(nullable = false, length = 500)
    private String coverPhotoUrl;

    @Column(nullable = false, length = 500)
    private String trailerURL;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getCoverPhotoUrl() {
        return coverPhotoUrl;
    }

    public void setCoverPhotoUrl(String coverPhotoUrl) {
        this.coverPhotoUrl = coverPhotoUrl;
    }

    public String getTrailerURL() {
        return trailerURL;
    }

    public void setTrailerURL(String trailerURL) {
        this.trailerURL = trailerURL;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", description='" + description + '\'' +
                ", releaseDate=" + releaseDate +
                ", duration=" + duration +
                ", coverPhotoUrl='" + coverPhotoUrl + '\'' +
                ", trailerURL='" + trailerURL + '\'' +
                '}';
    }
}
