package edu.csupomona.cs480.data.provider;

import java.util.List;

import edu.csupomona.cs480.data.Movie;

public interface MovieManager {

    public List<Movie> searchMovies(String keyword);
}
