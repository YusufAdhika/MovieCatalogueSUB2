package com.example.moviecataloguesub2.list_movie;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.moviecataloguesub2.R;
import com.example.moviecataloguesub2.detail_movie.DetailMovie;
import com.example.moviecataloguesub2.listmovie.WatchModel;

import java.util.ArrayList;

public class ListMovie extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ListWatchAdapter mAdapter;

    private ArrayList<WatchModel> modeList = new ArrayList<>();
    public static final String SELECTED_MOVIE = "sected_movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_movie);
        findViews();
        setAdapter();
    }

    private void findViews(){
        recyclerView = findViewById(R.id.recycler_view);
    }
    private void setAdapter(){

        modeList.add(new WatchModel(getResources().getString(R.string.title_a_star),getString(R.string.title_a_star),R.drawable.poster_a_star));
        modeList.add(new WatchModel(getResources().getString(R.string.title_aquaman),getString(R.string.title_aquaman),R.drawable.poster_aquaman));
        modeList.add(new WatchModel(getResources().getString(R.string.title_avengerinfinity),getString(R.string.title_avengerinfinity),R.drawable.poster_avengerinfinity));
        modeList.add(new WatchModel(getResources().getString(R.string.title_birdbox),getString(R.string.title_birdbox),R.drawable.poster_birdbox));
        modeList.add(new WatchModel(getResources().getString(R.string.title_bohemian),getString(R.string.title_bohemian),R.drawable.poster_bohemian));
        modeList.add(new WatchModel(getResources().getString(R.string.title_bumblebee),getString(R.string.title_bumblebee),R.drawable.poster_bumblebee));
        modeList.add(new WatchModel(getResources().getString(R.string.title_creed),getString(R.string.title_creed),R.drawable.poster_creed));
        modeList.add(new WatchModel(getResources().getString(R.string.title_deadpool),getString(R.string.title_deadpool),R.drawable.poster_deadpool));
        modeList.add(new WatchModel(getResources().getString(R.string.title_dragon),getString(R.string.title_dragon),R.drawable.poster_dragon));
        modeList.add(new WatchModel(getResources().getString(R.string.title_dragonball),getString(R.string.title_dragonball),R.drawable.poster_dragonball));
        modeList.add(new WatchModel(getResources().getString(R.string.title_glass),getString(R.string.title_glass),R.drawable.poster_glass));
        modeList.add(new WatchModel(getResources().getString(R.string.title_creed),getString(R.string.title_creed),R.drawable.poster_creed));


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mAdapter);


        mAdapter.SetOnItemClickListrner(new ListWatchAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, WatchModel model) {
                Intent goToDetailMovie = new Intent(ListMovie.this, DetailMovie.class);
                goToDetailMovie.putExtra(ListMovie.SELECTED_MOVIE,model);
                startActivity(goToDetailMovie);
            }
        });
    }
}
