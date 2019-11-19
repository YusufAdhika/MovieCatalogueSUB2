package com.example.moviecataloguesub2.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import android.os.Bundle;

public class PageViewModel extends ViewModel {
    private MutableLiveData<Integer> movieIndex = new MutableLiveData<>();
    private LiveData<String> movieText = Transformations.map(movieIndex, new Function<Integer, String>() {
        @Override
        public String apply(Integer input) {
            return "Hello World from selection" + input;
        }
    });

    public void setMovieText(int mIndex){
        movieIndex.setValue(mIndex);
    }
    public LiveData<String> getMovieText(){
        return movieText;
    }
    }

