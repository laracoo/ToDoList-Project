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
        Intent logInActivity = new Intent(this, LogInActivity.class);
        startActivity(logInActivity);
    }

    public void onSingInClickButton(View view) {
        Intent singInActivity = new Intent(this,SingInActivity.class);
        startActivity(singInActivity);
    }
}
