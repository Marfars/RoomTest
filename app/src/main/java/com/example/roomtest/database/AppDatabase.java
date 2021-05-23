package com.example.roomtest.database;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.roomtest.core.MyApplication;
import com.example.roomtest.database.dao.OfficialAccountDao;
import com.example.roomtest.database.model.OfficialAccountBean;

@Database(entities = {OfficialAccountBean.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance = null;
    private static final Object S_LOCK = new Object();

    public static AppDatabase getInstance() {
        synchronized (S_LOCK) {
            if (instance == null) {
                instance = Room.databaseBuilder(MyApplication.getContext(), AppDatabase.class, "room_test.db")
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build();
            }
            return instance;
        }
    }

    public abstract OfficialAccountDao getOfficialAccountDao();
}
