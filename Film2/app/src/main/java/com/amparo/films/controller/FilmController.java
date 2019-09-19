package com.amparo.films.controller;

import android.content.Context;

import androidx.room.Room;

import com.amparo.films.FilmDao;
import com.amparo.films.FilmDatabase;
import com.amparo.films.model.Film;
import java.util.List;

public class FilmController {

    private static FilmController controller;

    private FilmDao filmDao;

    private FilmController(Context context){
        Context appContext = context.getApplicationContext();
        FilmDatabase database = Room.databaseBuilder(appContext, FilmDatabase.class, "nota")
                .allowMainThreadQueries().build();
        filmDao = database.getFilmDao();
    }

    public static FilmController get (Context context)
    {
        if (controller == null){
            controller = new FilmController(context);
        }
        return controller;
    }

    public List<Film> getFilms()
    {
        return filmDao.getFilms();
    }

    public Film getFilm(String id)
    {
        return filmDao.getFilm(id);
    }

    public void createFilm(Film p)
    {
        filmDao.addFilm(p);
    }

    public void deleteFilm(Film p)
    {
        filmDao.deleteFilm(p);
    }

    public void updateFilm(Film p)
    {
        filmDao.updateFilm(p);
    }
}
