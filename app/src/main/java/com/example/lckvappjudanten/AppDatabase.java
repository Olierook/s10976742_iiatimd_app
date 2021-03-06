package com.example.lckvappjudanten;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Camper.class, version = 4)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CamperDao camperDao();

    private static AppDatabase instance;

    static synchronized AppDatabase getInstance(Context context){
        if (instance == null) {
            instance = create(context);
        }
        return instance;
    }

    private static AppDatabase create (final Context context){
        return Room.databaseBuilder(context, AppDatabase.class, "campers_and_products").allowMainThreadQueries().fallbackToDestructiveMigration().build();
    }
}
