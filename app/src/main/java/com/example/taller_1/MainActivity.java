package com.example.taller_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnAccess(View view) {
        EditText txtUser = (EditText) findViewById(R.id.txtUser);
        EditText txtPwd = (EditText) findViewById(R.id.txtPwd);
        if(txtUser.getText().toString().length() == 0 || txtPwd.getText().toString().length() == 0)
        {
            Toast.makeText(this, "Debe rellenar todos los campos" , Toast.LENGTH_LONG).show();
        }
        else
        {
            Intent intent = new Intent(MainActivity.this, Home.class);
            Bundle b = new Bundle();
            b.putString("User", txtUser.getText().toString());
            b.putString("Pwd", txtPwd.getText().toString());
            intent.putExtras(b);
            startActivity(intent);
        }
    }
}