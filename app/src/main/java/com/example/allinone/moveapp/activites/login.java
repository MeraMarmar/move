package com.example.allinone.moveapp.activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.allinone.moveapp.R;
import com.example.allinone.moveapp.backgroundWorker;

public class login extends AppCompatActivity {
    EditText edit_user,edit_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edit_user=(EditText)findViewById(R.id.edit_user);
        edit_pass=(EditText)findViewById(R.id.edit_pass);
    }
    public void login(View view) {
        String user=edit_user.getText().toString();
        String pass=edit_pass.getText().toString();
        String type="login";
        backgroundWorker backgroundWorker=new backgroundWorker(this);
        backgroundWorker.execute(type,user,pass);
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
