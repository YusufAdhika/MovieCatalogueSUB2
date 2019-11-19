package com.example.moviecataloguesub2.detail_movie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moviecataloguesub2.R;
import com.example.moviecataloguesub2.list_movie.ListMovie;
import com.example.moviecataloguesub2.listmovie.WatchModel;

import org.w3c.dom.Text;

public class DetailMovie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        TextView tvTitle = findViewById(R.id.tvTitle);
        TextView tvOverview = findViewById(R.id.tv_txt_overview);

        ImageView imgPoster = findViewById(R.id.imgposter);
        WatchModel watchModel = getIntent().getParcelableExtra(ListMovie.SELECTED_MOVIE);
        tvTitle.setText(watchModel.getString());
        tvOverview.setText(watchModel.getOverview());
        imgPoster.setImageResource(watchModel.getPoster());
        setTitle(watchModel.getString());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        }
        @Override
        public boolean onSupportNavigateUp() {
            finish();
            return true;
        }
    }
