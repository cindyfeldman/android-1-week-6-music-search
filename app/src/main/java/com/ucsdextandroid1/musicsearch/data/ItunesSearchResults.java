package com.ucsdextandroid1.musicsearch.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rjaylward on 2019-05-11
 */
public class ItunesSearchResults {

    private List<ItunesSongItem> songs;

    public List<ItunesSongItem> getSongs() {
        return songs;
    }

    public void setSongs(List<ItunesSongItem> songs) {
        this.songs = songs;
    }

}