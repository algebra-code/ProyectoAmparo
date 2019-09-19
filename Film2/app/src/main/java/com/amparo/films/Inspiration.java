package com.amparo.films;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.amparo.films.model.Film;
import com.amparo.films.model.FilmGhibli;
import com.amparo.films.retrofit.MyService;
import com.amparo.films.retrofit.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Inspiration extends AppCompatActivity {


    ListView listView;
    ArrayList<FilmGhibli> arrayG;
    GhibliAdapter adapterG;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspiration);

        listView = findViewById(R.id.listViewGhibli);
        arrayG = new ArrayList<>();
        adapterG = new GhibliAdapter(this,R.layout.row_ghibli,arrayG);
        listView.setAdapter(adapterG);

        serverG();

    }

    private void serverG (){

        //fer una instancia de MyService
        MyService service = RetrofitClientInstance.getRetrofitInstance().create(MyService.class);

        //fer la crida i capturar resultat o error
        Call<List<FilmGhibli>> call = service.getFilmGhibli();
        call.enqueue(new Callback<List<FilmGhibli>>() {
            @Override
            public void onResponse(Call<List<FilmGhibli>> call, Response<List<FilmGhibli>> response) {

                if(response.body()!=null){

                    arrayG.clear();
                    arrayG.addAll(response.body());

                    adapterG.notifyDataSetChanged();
                }

            }
            @Override
            public void onFailure(Call<List<FilmGhibli>> call, Throwable t) {
                //mostrar error
            }
        });
    }
    /*
    //return to Main Activity
    public void close() {
        finish();
    }*/

}








