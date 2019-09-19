package com.amparo.films;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.amparo.films.controller.FilmController;
import com.amparo.films.model.Film;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SharedPreferences prefs;

    ListView listView;
    ArrayList<Film> peliculas;
    FilmAdapter adapter;
    FilmController controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Open Login if necessary through Preferences
        prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        String value = prefs.getString("valor", "");
        if(value==""){
            Intent i = new Intent(this, Login.class);
            startActivity (i);
        }


        //ActionBar: add title (al final no)
        getSupportActionBar().setTitle("");

        //ListView
        listView = findViewById(R.id.listView);
        peliculas = new ArrayList<Film>();

        //adapter between ArrayList and ListView
        adapter = new FilmAdapter(this, R.layout.row, peliculas);
        listView.setAdapter(adapter);    //Asign adapter to listView

        //controller
        controller = FilmController.get(this);

        //ListView click
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Open Info.class
                Intent intent = new Intent(MainActivity.this, Info.class);
                //id of the film for the Info.class
                intent.putExtra("idFilm", peliculas.get(position).getId());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        //showFilms inside onResume to update the list every time we get in
        showFilms();
    }

    private void showFilms() {
        peliculas.clear(); //To clear the arrayList
        peliculas.addAll(controller.getFilms()); //To add films
        adapter.notifyDataSetChanged(); //Refresh the listView
    }

    //ActionBar: add items to the bar with Inflate
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_actionbar, menu);
        return true;
    }

    //ActionBar: option selected
    @Override
    public boolean onOptionsItemSelected(MenuItem opciones_menu) {
        switch (opciones_menu.getItemId()) {
            case R.id.bar_inspiration:
                goToInspirationActivity();
                return (true);
            case R.id.bar_add:
                goToAddActivity();
                return (true);
        }
        return (super.onOptionsItemSelected(opciones_menu));
    }

    //abrir Add Activity
    public void goToAddActivity (){
        Intent i = new Intent(this, Add.class);
        startActivity (i);
    }

    //abrir Inspiration Activity
    public void goToInspirationActivity (){
        Intent i = new Intent(this,Inspiration.class);
        startActivity (i);
    }

}
