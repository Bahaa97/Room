package com.task.senior;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @BindView(R.id.student_name_ET)
    EditText studentNameET;
    @BindView(R.id.dataTV)
    TextView dataTV;

    @BindView(R.id.get_all_btn)
    Button getAllBtn;
    @BindView(R.id.delete_btn)
    Button deleteBtn;
    @BindView(R.id.update_btn)
    Button updateBtn;
    @BindView(R.id.insert_btn)
    Button insertBtn;

    private StudentDao dao;
    private int id = 24;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        init();
    }

    private void init() {
        getAllBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);
        updateBtn.setOnClickListener(this);
        insertBtn.setOnClickListener(this);

        dao = StudentDatabase.getInstance(this).studentDao();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.get_all_btn:
                getAllData();
                break;

            case R.id.delete_btn:
                delete();
                break;

            case R.id.update_btn:
                update();
                break;

            case R.id.insert_btn:
                insert();
                break;
        }
    }

    private void insert() {
        Student student = new Student();
        student.setId(id++);
        student.setName("Yehia");

        dao.insertStudent(student);
    }

    private void update() {
        Student student = new Student();
        student.setId(22);
        student.setName("Yehia");

        dao.updateStudent(student);
    }

    private void delete() {

        Student student = new Student();
        student.setId(22);
        student.setName("Yehia");

        dao.deleteStudnet(student);
    }

    private void getAllData() {

        new DatabaseTask(dao, new OnDataReterivalListener() {
            @Override
            public void onData(List<Student> students) {
                dataTV.setText(String.valueOf(students.size()));
            }
        }).execute();


    }
}
