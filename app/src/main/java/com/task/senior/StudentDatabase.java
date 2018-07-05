package com.task.senior;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(version = 1, entities = Student.class, exportSchema = false)
abstract public class StudentDatabase extends RoomDatabase {

    private static StudentDatabase instance;


    public static StudentDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, StudentDatabase.class, "schooldb")
//                    .allowMainThreadQueries()
                    .build();
        }


        return instance;
    }

    public abstract StudentDao studentDao();

}
