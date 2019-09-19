package com.amparo.films;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.amparo.films.controller.FilmController;
import com.amparo.films.model.Film;

public class Add extends AppCompatActivity {

    EditText et_title, et_description, et_year, et_points, et_url;
    FilmController controller;
    Film film;
    String id;
    Button btn_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        et_title = findViewById(R.id.et_title);
        et_description = findViewById(R.id.et_description);
        et_year = findViewById(R.id.et_year);
        et_points = findViewById(R.id.et_points);
        et_url = findViewById(R.id.et_url);
        btn_add = findViewById(R.id.btn_add);
        controller = FilmController.get(this);

        //pick up id
        id = getIntent().getStringExtra("idFilm");
        if (id != null) {
            film = controller.getFilm(id);
            showFilm();   //show info
        }
    }

    public void showFilm() {
        et_title.setText(film.getTitle());
        et_description.setText(film.getDescription());
        et_year.setText(film.getYear());
        et_points.setText(film.getPoint());
        et_url.setText(film.getUrl());
    }

    //Add film
    public void addFilm(View view) {
        String title = et_title.getText().toString();
        String description = et_description.getText().toString();
        String year = et_year.getText().toString();
        String points = et_points.getText().toString();
        String url = et_url.getText().toString();


        //check empty
        if (checkFields()) {
            if (id != null) {
                film.setTitle(title);
                film.setDescription(description);
                film.setYear(year);
                film.setPoint(Integer.parseInt(points));
                film.setUrl(url);

                controller.updateFilm(film);

            } else {
                Film peli = new Film(title, description, year, Integer.parseInt(points), url);
                controller.createFilm(peli);
            }


            finish();
        }
    }

    //check empty fields
    private boolean checkFields() {

        boolean fieldsOk = true;


        if ("".equals(et_title.getText().toString())) {
            et_title.setError(getString(R.string.err_title));
            fieldsOk = false;
        }
        if ("".equals(et_description.getText().toString())) {
            et_description.setError(getString(R.string.err_description));
            fieldsOk = false;
        }
        if ("".equals(et_year.getText().toString())) {
            et_year.setError(getString(R.string.err_year));
            fieldsOk = false;
        }

        if ("".equals(et_url.getText().toString())) {
            et_url.setError(getString(R.string.err_url));
            fieldsOk = false;
        }

        if ("".equals(et_points.getText().toString())) {
            et_points.setError(getString(R.string.err_points));
            fieldsOk = false;
        } else {

            int valor = Integer.parseInt(et_points.getText().toString());
            if (valor < 0 || valor > 5) {

                //falta limitar MIN y MAX
                et_points.setError(getString(R.string.err_points));
                fieldsOk = false;
            }
        }
        return fieldsOk;
    }
}
/*
    //check points between 0-5
    public void valorOk(){
        int valor = Integer.parseInt(et_points.getText().toString());

        if(valor<0 && valor>5){
            //falta limitar MIN y MAX
            et_points.setError(getString(R.string.err_points));
            fieldsOk = false;
        }
    }*/

