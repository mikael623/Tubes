package com.example.tubes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class NewNote extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

        String[] type = new String[] {"7th Grade", "8th Grade", "9th Grade"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.pop_up_grade, type);
        AutoCompleteTextView editTextFilledExposedDropdown = findViewById(R.id.filled_exposed_dropdown);
        editTextFilledExposedDropdown.setAdapter(adapter);
    }
}