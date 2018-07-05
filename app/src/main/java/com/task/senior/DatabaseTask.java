package com.task.senior;

import android.os.AsyncTask;

import java.util.List;

public class DatabaseTask extends AsyncTask<Void, Void, List<Student>> {

    private StudentDao dao;
    private OnDataReterivalListener onDataReterivalListener;

    public DatabaseTask(StudentDao studentDao, OnDataReterivalListener onDataReterivalListener) {
        dao = studentDao;
        this.onDataReterivalListener = onDataReterivalListener;
    }

    @Override
    protected List<Student> doInBackground(Void... voids) {
        return dao.getStudnets();

    }

    @Override
    protected void onPostExecute(List<Student> student) {
        super.onPostExecute(student);

        onDataReterivalListener.onData(student);
    }
}
