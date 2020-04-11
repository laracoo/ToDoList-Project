package com.example.todolist_first_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

// The main menu where is the user can continue work by pushing "Start" button or change settings in the app
public class  MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClickNext(View view) {
        Intent enterActivity = new Intent(this, EnterActivity.class);
        startActivity(enterActivity);
    }

    public void onButtonClickSettings(View view) {
        Intent settingsActivity = new Intent(this, SettingsForApp.class);
        startActivity(settingsActivity);
    }
}
