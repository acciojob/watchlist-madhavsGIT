package com.driver;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {

    private HashMap<String, Movie> movieMap;
    private HashMap<String, Director> directorMap;
    private HashMap<String, List<String>> directorMovieMapping;

    public MovieRepository(){
        this.movieMap = new HashMap<String, Movie>();
        this.directorMap = new HashMap<String, Director>();
        this.directorMovieMapping = new HashMap<String, List<String>>();
    }

    public void saveMovie(Movie movie){
        // your code here
        String key = movie.getName();
        movieMap.put(key, movie);
    }

    public void saveDirector(Director director){
        // your code here
        String key = director.getName();
        directorMap.put(key, director);
    }

    public void saveMovieDirectorPair(String movie, String director){
        if(movieMap.containsKey(movie) && directorMap.containsKey(director)){
            // your code here
            if (directorMovieMapping.containsKey(director)) {
                List<String> movieList = directorMovieMapping.get(director);
                if (!movieList.contains(movie)) {
                    movieList.add(movie);
                    directorMovieMapping.put(director, movieList);
                }
            } else {
                List<String> newMovieList = new ArrayList<>();
                newMovieList.add(movie);
                directorMovieMapping.put(director, newMovieList);
            }

        }
    }

    public Movie findMovie(String movie){
        // your code here
        if(movieMap.containsKey(movie)){
            return movieMap.get(movie);
        }
        return null;
    }

    public Director findDirector(String director){
        // your code here
        if(directorMap.containsKey(director)){
            return directorMap.get(director);
        }
        return null;
    }

    public List<String> findMoviesFromDirector(String director){
        // your code here

        if(directorMovieMapping.containsKey(director)){
            return directorMovieMapping.get(director);
        }
        return null;

    }

    public List<String> findAllMovies(){
        return new ArrayList<>(movieMap.keySet());
    }

    public void deleteDirector(String director){
        // your code here
        if(directorMap.containsKey(director)){
            directorMap.remove(director);
            //directorMovieMapping.remove(director);
        }
    }

    public void deleteAllDirector(){
        // your code here
        directorMap.clear();
    }
}