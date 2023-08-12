package com.upgrad.MovieApp.dao;

import com.upgrad.MovieApp.Entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDAO extends JpaRepository<Movie, Integer> {
}
