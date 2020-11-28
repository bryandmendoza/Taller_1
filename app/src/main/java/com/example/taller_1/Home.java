package com.example.taller_1;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.taller_1.WebService.Asynchtask;
import com.example.taller_1.WebService.WebService;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

public class Home extends AppCompatActivity implements Asynchtask {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Bundle bundle = this.getIntent().getExtras();
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws = new WebService("http://uealecpeterson.net/ws/login.php?usr="
                + bundle.getString("User") + "&pass=" + bundle.getString("Pwd"),
                datos, Home.this, Home.this);
        ws.execute("GET");
        Log.d("Prueba", "Miguel puto");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        TextView txtWelcome = (TextView)findViewById(R.id.txtWelcome);
        txtWelcome.setText("Respuesta del WS: " + result);
    }
}