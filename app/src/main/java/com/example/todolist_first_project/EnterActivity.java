package com.example.todolist_first_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EnterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
    }

    public void onLogInClickButton(View view) {
        Intent taskActivity = new Intent(this,TasksActivity.class);
        startActivity(taskActivity);
    }
}
