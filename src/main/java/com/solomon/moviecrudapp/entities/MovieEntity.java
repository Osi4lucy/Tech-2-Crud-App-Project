package com.solomon.moviecrudapp.entities;

public class MovieEntity {
    private int movie_id;
    private String movie_title;
    private String genre;
    private int year_of_release;
    private String producer;
    private int rating;
    private String language;

    public MovieEntity(){
    }

    public MovieEntity(int movie_id, String movie_title, String genre, int year_of_release, String producer, int rating, String language) {
        this.movie_id=movie_id;
        this.movie_title=movie_title;
        this.genre=genre;
        this.year_of_release=year_of_release;
        this.producer=producer;
        this.rating=rating;
        this.language=language;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id=movie_id;
    }

    public String getMovie_title() {
        return movie_title;
    }

    public void setMovie_title(String movie_title) {
        this.movie_title=movie_title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre=genre;
    }

    public int getYear_of_release() {
        return year_of_release;
    }

    public void setYear_of_release(int year_of_release) {
        this.year_of_release=year_of_release;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer=producer;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating=rating;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language=language;
    }

    @Override
    public String toString() {
        return "MovieEntity{" +
                "movie_id=" + movie_id +
                ", movie_title='" + movie_title + '\'' +
                ", genre='" + genre + '\'' +
                ", year_of_release=" + year_of_release +
                ", producer='" + producer + '\'' +
                ", rating=" + rating +
                ", language='" + language + '\'' +
                '}';
    }
}
