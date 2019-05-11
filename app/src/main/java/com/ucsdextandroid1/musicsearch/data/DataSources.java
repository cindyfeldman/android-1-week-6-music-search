package com.ucsdextandroid1.musicsearch.data;

import android.nfc.Tag;
import android.util.Log;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by rjaylward on 2019-05-10
 */
public class DataSources {

    private static DataSources instance;
    private ItunesApi itunesApi;

    private DataSources() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(ItunesSearchResults.class, new ItunesSearchResultsDeserialzer())
                .create();
        this.itunesApi = new Retrofit.Builder()
                .baseUrl("https://itunes.apple.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(ItunesApi.class)
        ;

        //TODO create a custom gson
        //TODO use retrofit to create an instance of the itunesApi
    }

    public static DataSources getInstance() {
        if (instance == null)
            instance = new DataSources();

        return instance;
    }

    public void search(String searchTerm, Callback<List<? extends SongItem>> callback) {
        //TODO call the itunesApi and return an empty list on any failures
        itunesApi.searchItunes(searchTerm).enqueue(new retrofit2.Callback<ItunesSearchResults>() {
            @Override
            public void onResponse(Call<ItunesSearchResults> call, Response<ItunesSearchResults> response) {
                if (response.isSuccessful()) {
                    Log.d("Success", "is Successful");
                    callback.onDataFetched(response.body().getSongs());

                } else
                    callback.onDataFetched(Collections.emptyList());
            }

            @Override
            public void onFailure(Call<ItunesSearchResults> call, Throwable t) {

                callback.onDataFetched(Collections.emptyList());
            }
        });

    }

    public interface Callback<T> {
        void onDataFetched(T data);
    }

    public interface ItunesApi {
        //TODO add a method that corresponds to the search method on the iTunesApi
        @GET("search?media=music&limit=25")
        Call<ItunesSearchResults> searchItunes(@Query("term") String term);
    }
}
