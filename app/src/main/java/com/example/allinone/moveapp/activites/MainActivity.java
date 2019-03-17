package com.example.allinone.moveapp.activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.allinone.moveapp.R;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText editN, editp, editcp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editN = findViewById(R.id.editN);
        editp = findViewById(R.id.editN);
        editcp = findViewById(R.id.editN);


    }




}
