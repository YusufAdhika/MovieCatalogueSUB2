package com.example.moviecataloguesub2.listmovie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;

import android.os.Bundle;

import java.util.ArrayList;

public class ListMovieViewModel extends ViewModel {
    private ArrayList<WatchModel> modelList = new ArrayList<>();

    public void addMovieModel(String title, String overview, Integer poster){
        this.modelList.add(new WatchModel(title,overview,poster));
    }
    public ArrayList<WatchModel> getModelList(){
        return modelList;
    }
}
