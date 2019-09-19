package com.amparo.films;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.amparo.films.model.Film;
import java.util.List;


@Dao
public interface FilmDao {
    @Query("SELECT * From film")
    List<Film> getFilms();

    @Query("SELECT * FROM film where id like :uuid")
    Film getFilm(String uuid);

    @Insert
    void addFilm(Film n);

    @Delete
    void deleteFilm(Film n);

    @Update
    void updateFilm(Film n);
}
