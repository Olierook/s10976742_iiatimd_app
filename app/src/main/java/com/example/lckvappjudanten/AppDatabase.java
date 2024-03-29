package com.example.lckvappjudanten;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Product.class, Camper.class, ActiveUser.class}, version = 7)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ProductDao productDao();
    public abstract CamperDao camperDao();
    public abstract ActiveUserDao activeUserDao();
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
