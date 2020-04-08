package com.learning.helloworld;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            getSupportActionBar().hide();
        }

        StudentsFragment studentsFragment = StudentsFragment.newInstance(new StudentsFragment.StudentClickListener() {
            @Override
            public void onStudentClicked(Student student) {
                showStudentCard(student);
            }
        });
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, studentsFragment)
                .commit();
    }

    private void showStudentCard(Student student) {
        StudentCardFragment studentCardFragment = StudentCardFragment.newInstance(student);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, studentCardFragment)
                .addToBackStack(null)
                .commit();
    }
}
