package com.example.moviecataloguesub2.listtvshow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.moviecataloguesub2.listmovie.WatchModel;

import java.util.ArrayList;

public class ListTvShowViewModel extends ViewModel {
    private ArrayList<WatchModel> modelList = new ArrayList<>();

    public void masukanFilm(String title, String overview, Integer poster){
        this.modelList.add(new WatchModel(title, overview, poster));
    }
    public ArrayList<WatchModel> getTvShowList(){
        return modelList;
    }
}
