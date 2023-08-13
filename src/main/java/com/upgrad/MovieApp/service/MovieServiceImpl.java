package com.upgrad.MovieApp.service;

import com.upgrad.MovieApp.Entities.Movie;
import com.upgrad.MovieApp.dao.MovieDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    public MovieDAO movieDAO;
    @Override
    public Movie acceptMovieDetails(Movie movie) {
        return movieDAO.save(movie);
    }

    @Override
    @Transactional
    public List<Movie> acceptMultipleMovieDetails(List<Movie> movies) {

        List<Movie> savedMovies = new ArrayList<Movie>();
        for(Movie movie:  movies){
            Movie savedmovie = acceptMovieDetails(movie);
            savedMovies.add(savedmovie);
        }
        return savedMovies;
    }

    @Override
    public Movie getMovieDetails(int id) {
        return movieDAO.getById(id);
    }

    @Override
    public Movie updateMovieDetails(int movieId, Movie movie) {
        Movie savedMovie = getMovieDetails(movieId);
        savedMovie.setMovieName(movie.getMovieName());
        savedMovie.setDescription(movie.getDescription());
        savedMovie.setDuration(movie.getDuration());
        savedMovie.setReleaseDate(movie.getReleaseDate());
        savedMovie.setCoverPhotoUrl(movie.getCoverPhotoUrl());
        savedMovie.setTrailerURL(movie.getTrailerURL());
        return movieDAO.save(savedMovie);
    }

    @Override
    public boolean deleteMovie(int id) {
        Movie savedMovie = getMovieDetails(id);
        if(savedMovie == null)
            return false;
        movieDAO.delete(savedMovie);
        return true;
    }

    @Override
    public List<Movie> getAllMoviesDetails() {
        return movieDAO.findAll();
    }

    @Override
    public List<Movie> getPaginatedMovieDetails(Pageable pageRequest) {
        return (List<Movie>) movieDAO.findAll(pageRequest);
    }
}
