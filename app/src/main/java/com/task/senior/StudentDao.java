package com.task.senior;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface StudentDao {

    @Query("SELECT * FROM student")
    List<Student> getStudnets();

    @Query("SELECT * FROM student WHERE id LIKE :id")
    List<Student> getStudentsById(int id);

    @Insert
    void insertStudent(Student... student);

    @Delete
    void deleteStudnet(Student student);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateStudent(Student student);


}
