package com.amparo.films;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.amparo.films.controller.FilmController;
import com.amparo.films.model.Film;
import com.squareup.picasso.Picasso;

public class Info extends AppCompatActivity {

    TextView tv_title, tv_description, tv_year, tv_points;
    ImageView iv_url;
    String id;
    FilmController controller;
    Film film;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        tv_title = findViewById(R.id.tv_title);
        tv_description = findViewById(R.id.tv_description);
        tv_year = findViewById(R.id.tv_year);
        tv_points = findViewById(R.id.tv_points);
        iv_url = findViewById(R.id.iv_url);



        //pick up id of film from list
        id = getIntent().getStringExtra("idFilm");
        //use id to pick up film from  BdD SQLite
        controller = FilmController.get(this);
        film = controller.getFilm(id);




        showFilm();
    }

    //show film info
    private void showFilm()    {
        tv_title.setText(film.getTitle());
        tv_description.setText(film.getDescription());
        tv_year.setText(film.getYear());
        tv_points.setText(String.valueOf(film.getPoint()));

        //Picasso
        String image = film.getUrl();
        Picasso.get().load(image).into(iv_url);
    }

    //Delete film
    public void deleteFilm(View view) {
        controller.deleteFilm(film);
        finish();
    }

}