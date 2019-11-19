package com.example.moviecataloguesub2.listmovie;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moviecataloguesub2.R;
import com.example.moviecataloguesub2.detail_movie.DetailMovie;
import com.example.moviecataloguesub2.list_movie.ListMovie;
import com.example.moviecataloguesub2.list_movie.ListWatchAdapter;

public class ListMovieFragment extends Fragment {
    private ListMovieViewModel mViewModel;
    private ListWatchAdapter mAdapter;

    public static ListMovieFragment newInstance(){
        return new ListMovieFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_movies_fragment,container,false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        mViewModel = ViewModelProviders.of(this).get(ListMovieViewModel.class);
        mViewModel.addMovieModel(getResources().getString(R.string.title_avengerinfinity),getString(R.string.Overview_avengerinfinity),R.drawable.poster_avengerinfinity);
        mViewModel.addMovieModel(getResources().getString(R.string.title_creed),getString(R.string.Overview_creed),R.drawable.poster_creed);
        mViewModel.addMovieModel(getResources().getString(R.string.title_glass),getString(R.string.Overview_glass),R.drawable.poster_glass);
        mViewModel.addMovieModel(getResources().getString(R.string.title_dragonball),getString(R.string.Overview_dragonball),R.drawable.poster_dragonball);
        mViewModel.addMovieModel(getResources().getString(R.string.title_dragon),getString(R.string.Overview_dragon),R.drawable.poster_dragon);
        mViewModel.addMovieModel(getResources().getString(R.string.title_deadpool),getString(R.string.Overview_deadpool),R.drawable.poster_deadpool);
        mViewModel.addMovieModel(getResources().getString(R.string.title_bumblebee),getString(R.string.Overview_bumblebee),R.drawable.poster_bumblebee);
        mViewModel.addMovieModel(getResources().getString(R.string.title_bohemian),getString(R.string.Overview_bohemian),R.drawable.poster_bohemian);
        mViewModel.addMovieModel(getResources().getString(R.string.title_birdbox),getString(R.string.Overview_birdbox),R.drawable.poster_birdbox);
        mViewModel.addMovieModel(getResources().getString(R.string.title_aquaman),getString(R.string.Overview_aquaman),R.drawable.poster_aquaman);
        mViewModel.addMovieModel(getResources().getString(R.string.title_a_star),getString(R.string.Overview_a_star),R.drawable.poster_a_star);
        mViewModel.addMovieModel(getResources().getString(R.string.title_hunterkiller),getString(R.string.Overview_hunterkiller),R.drawable.poster_hunterkiller);



        mAdapter = new ListWatchAdapter(view.getContext(),mViewModel.getModelList());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);

        mAdapter.SetOnItemClickListrner(new ListWatchAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, WatchModel model) {
                Intent goToDetailMovie = new Intent(view.getContext(), DetailMovie.class);
                goToDetailMovie.putExtra(ListMovie.SELECTED_MOVIE,model);
                startActivity(goToDetailMovie);
            }
        });
    }
}
