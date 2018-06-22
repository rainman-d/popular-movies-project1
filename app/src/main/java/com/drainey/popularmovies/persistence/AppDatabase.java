package com.drainey.popularmovies.persistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.util.Log;

import com.drainey.popularmovies.model.Movie;

/**
 * Created by david-rainey on 6/17/18.
 */
@Database(entities = {Movie.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static final String TAG = AppDatabase.class.getSimpleName();
    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "popular_movies";
    private static AppDatabase sInstance;

    public static AppDatabase getInstance(Context context){
        if(sInstance == null){
            synchronized (LOCK){
                Log.d(TAG, "Creating new instance of database");
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class, DATABASE_NAME).build();
            }
        }
        Log.d(TAG, "getting the database instance");
        return sInstance;
    }

    // method to retrieve the movieDao interface to perform queries
    public abstract MovieDao movieDao();
}
