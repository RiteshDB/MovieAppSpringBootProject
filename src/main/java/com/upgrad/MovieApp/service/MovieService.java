package com.upgrad.MovieApp.service;

import com.upgrad.MovieApp.Entities.Movie;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MovieService {

    public Movie acceptMovieDetails(Movie movie);

    public List<Movie> acceptMultipleMovieDetails(List<Movie> movies);

    public Movie getMovieDetails(int id);

    public Movie updateMovieDetails(int movieId, Movie movie);

    public boolean deleteMovie(int id);

    public List<Movie> getAllMoviesDetails();

    public List<Movie> getPaginatedMovieDetails(Pageable pageRequest);

}
