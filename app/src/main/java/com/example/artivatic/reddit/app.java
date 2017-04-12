package com.example.artivatic.reddit;

import android.app.Application;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by artivatic on 30/3/17.
 */

public class app extends Application {
    BookResponse.Info[] info;


    @Override
    public void onCreate() {



        super.onCreate();

        RealmConfiguration config=new RealmConfiguration.Builder(this).deleteRealmIfMigrationNeeded().build();
        Realm.setDefaultConfiguration(config);



    }




}
