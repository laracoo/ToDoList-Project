package com.example.todolist_first_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class TasksActivity extends AppCompatActivity {

    ArrayList arrayList;
    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    int chosenItemPosition;
    private static final String PREFERENCES_2 = "PREFERENCES_TODO_LIST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        arrayList = new ArrayList();

        SharedPreferences preferencesRestore = getSharedPreferences(PREFERENCES_2,MODE_PRIVATE);
        for (int i = 0; i <preferencesRestore.getInt("length", 0); i++) {
            arrayList.add(preferencesRestore.getString(String.valueOf(i), ""));
        }
        listView = findViewById(R.id.list_of_tasks);
        arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_single_choice, arrayList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                chosenItemPosition = position;
            }
        });
    }

    public void onClickButtonAdd(View view) {
        EditText editText = findViewById(R.id.add_task_editText);
        String item = editText.getText().toString();
        if(item.equals("")) {
            Toast toast = Toast.makeText(this, "Add task!", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        } else {
            arrayList.add(item);
            arrayAdapter.notifyDataSetChanged();
            editText.setText("");
        }
    }

    public void onClickButtonDelete(View view) {
        if(arrayList.size() == 0) {
            Toast toast = Toast.makeText(this, "ToDo List already empty!", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        } else {
            arrayList.remove(chosenItemPosition);
            arrayAdapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onSaveData();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        onSaveData();
    }

    void onSaveData() {
        String[] items = (String[]) arrayList.toArray(new String[0]);
        SharedPreferences preferecesSave = getSharedPreferences(PREFERENCES_2, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferecesSave.edit();
        for (int i = 0; i < items.length; i++) {
            editor.putString(String.valueOf(i),items[i]);
        }
        editor.putInt("length", items.length);
        editor.apply();
    }
}
