package com.amparo.films;

import com.amparo.films.model.Film;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Film.class}, version = 1)
public abstract class FilmDatabase extends RoomDatabase {
    public abstract FilmDao getFilmDao();
}
