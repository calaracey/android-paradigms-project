package com.example.shreyakumar.lec01_fall19_practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mStudentListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStudentListView = (TextView) findViewById(R.id.tv_student_names);
        System.out.println("DEBUG:@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@: " + mStudentListView.getText());
        mStudentListView.append("\n\n\nHermes\n\n\nJohn\n\n\nMaria");
        String[] studentNames = {"Timothy", "Kathryn", "Alex"};
        for(String studentName : studentNames){
            mStudentListView.append("\n\n\n" + studentName);
        }

    }
}
