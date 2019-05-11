package com.ucsdextandroid1.musicsearch.search;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;
import com.ucsdextandroid1.musicsearch.R;
import com.ucsdextandroid1.musicsearch.data.ItunesSongItem;
import com.ucsdextandroid1.musicsearch.data.SongItem;
import com.ucsdextandroid1.musicsearch.utils.Utils;

public class MusicDetailsActivity extends AppCompatActivity  {
    private SongItem currentSongItem;
    private ImageView imageView;
    private TextView titleView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitymusicdetails);
        imageView = findViewById(R.id.imageURL);
        titleView = findViewById(R.id.myTitle);
        SongItem item = getIntent().getParcelableExtra("Song");
            if(item != null){
              bind(item);
              titleView.setText(currentSongItem.getTrackName());
            }
    }
    public void bind(SongItem songItem) {
    currentSongItem = songItem;

        Picasso.get().load(songItem.getArtworkUrl())
                .placeholder(new ColorDrawable(Utils.randomColor()))
                .into(imageView);


    }
}
