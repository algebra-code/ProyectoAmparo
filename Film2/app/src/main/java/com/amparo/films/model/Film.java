package com.amparo.films.model;

import androidx.annotation.NonNull;
import java.util.UUID;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "film")
public class Film {
    @PrimaryKey
    @NonNull
    public String id;
    public String title;
    public String description;
    public String year;
    public int point;
    public String url;

    public Film() {
        id = UUID.randomUUID().toString();
    }

    public Film(String title, String description, String year, int point, String url) {
        id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.year = year;
        this.point = point;
        this.url = url;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}