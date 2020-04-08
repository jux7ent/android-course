package com.learning.helloworld;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class StudentCardFragment extends Fragment {
    private Student student;

    static StudentCardFragment newInstance(Student student) {
        StudentCardFragment studentCardFragment = new StudentCardFragment();
        studentCardFragment.student = student;
        return studentCardFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View studentCardView = inflater.inflate(R.layout.student_card, container, false);
        ((TextView)studentCardView.findViewById(R.id.textFirstName)).setText(student.getFirstName());
        ((TextView)studentCardView.findViewById(R.id.textLastName)).setText(student.getLastName());

        Toolbar toolbar = studentCardView.findViewById(R.id.toolbarStudentCard);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        return studentCardView;
    }
}
