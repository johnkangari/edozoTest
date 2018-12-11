package com.edozo.test.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "film")
public class Film {
    @Id
    @Column(name = "film_id")
    private int id;
    private String title;
    private String description;
    private int release_year;
    private int language_id;
    private int rental_duration;
    private double rental_rate;
    private int length;
    private double replacement_cost;
    private String rating;
    private Date last_update;
    private List<String> special_features;
    private String fulltext;

    public Film(int id, String title, String description, int release_year, int language_id, int rental_duration, double rental_rate, int length, double replacement_cost, String rating, Date last_update, List<String> special_features, String fulltext) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.release_year = release_year;
        this.language_id = language_id;
        this.rental_duration = rental_duration;
        this.rental_rate = rental_rate;
        this.length = length;
        this.replacement_cost = replacement_cost;
        this.rating = rating;
        this.last_update = last_update;
        this.special_features = special_features;
        this.fulltext = fulltext;
    }

    public Film() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }

    public int getRental_duration() {
        return rental_duration;
    }

    public void setRental_duration(int rental_duration) {
        this.rental_duration = rental_duration;
    }

    public double getRental_rate() {
        return rental_rate;
    }

    public void setRental_rate(double rental_rate) {
        this.rental_rate = rental_rate;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getReplacement_cost() {
        return replacement_cost;
    }

    public void setReplacement_cost(double replacement_cost) {
        this.replacement_cost = replacement_cost;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    public List<String> getSpecial_features() {
        return special_features;
    }

    public void setSpecial_features(List<String> special_features) {
        this.special_features = special_features;
    }

    public String getFulltext() {
        return fulltext;
    }

    public void setFulltext(String fulltext) {
        this.fulltext = fulltext;
    }
}
