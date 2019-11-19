package com.example.moviecataloguesub2.listtvshow;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviecataloguesub2.R;
import com.example.moviecataloguesub2.detail_movie.DetailMovie;
import com.example.moviecataloguesub2.list_movie.ListMovie;
import com.example.moviecataloguesub2.list_movie.ListWatchAdapter;
import com.example.moviecataloguesub2.listmovie.WatchModel;

public class TvShowListFragment extends Fragment {
    private ListTvShowViewModel listViewModel;
    private ListWatchAdapter movieAdabter;

    public static TvShowListFragment newInstance(){
        return new TvShowListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_tv_show_fragment,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        listViewModel = ViewModelProviders.of(this).get(ListTvShowViewModel.class);
        listViewModel.masukanFilm(getResources().getString(R.string.tv_title_tom), getString(R.string.tv_overview_tom), R.drawable.tom);
        listViewModel.masukanFilm(getResources().getString(R.string.tv_title_titans), getString(R.string.tv_overview_titans), R.drawable.titans);
        listViewModel.masukanFilm(getResources().getString(R.string.tv_title_therookie), getString(R.string.tv_overview_therookie), R.drawable.rookie);
        listViewModel.masukanFilm(getResources().getString(R.string.tv_title_theresident), getString(R.string.tv_overview_theresident), R.drawable.recident);
        listViewModel.masukanFilm(getResources().getString(R.string.tv_title_magnum), getString(R.string.tv_overview_magnum), R.drawable.magnum);
        listViewModel.masukanFilm(getResources().getString(R.string.tv_title_kyripton), getString(R.string.tv_overview_kyripton), R.drawable.krypton);
        listViewModel.masukanFilm(getResources().getString(R.string.tv_title_fbi), getString(R.string.tv_overview_fbi), R.drawable.fbi);
        listViewModel.masukanFilm(getResources().getString(R.string.tv_title_britannia), getString(R.string.tv_overview_britannia), R.drawable.britannia);
        listViewModel.masukanFilm(getResources().getString(R.string.tv_title_castilrock), getString(R.string.tv_overview_castlerock), R.drawable.castlerock);
        listViewModel.masukanFilm(getResources().getString(R.string.tv_title_amillionlittle), getString(R.string.tv_overview_amilliontittle), R.drawable.miliionthings);
        listViewModel.masukanFilm(getResources().getString(R.string.tv_title_911), getString(R.string.tv_overview_911), R.drawable.sembilansatusatu);
        listViewModel.masukanFilm(getResources().getString(R.string.tv_title_legacies), getString(R.string.tv_overview_legacies), R.drawable.legacies);

        movieAdabter = new ListWatchAdapter(view.getContext(),listViewModel.getTvShowList());
        recyclerView.setAdapter(movieAdabter);
        recyclerView.setHasFixedSize(true);

        movieAdabter.SetOnItemClickListrner(new ListWatchAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, WatchModel model) {
                Intent moveToDetailMovie = new Intent(view.getContext(), DetailMovie.class);
                moveToDetailMovie.putExtra(ListMovie.SELECTED_MOVIE,model);
                startActivity(moveToDetailMovie);
            }
        });

    }
}
