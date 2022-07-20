package com.example.convertor_l;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button mb1, mb2, mb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mb1 = (Button) findViewById(R.id.currency_but);
        mb2 = (Button) findViewById(R.id.distance_but);
        mb3 = (Button) findViewById(R.id.temperature_but);

        mb1.setOnClickListener( v -> opencurrency());
        mb2.setOnClickListener( v -> opendistance());
        mb3.setOnClickListener( v -> opentemperature());

    }

    public void opencurrency(){
        Intent intent = new Intent(this,currency.class);
        startActivity(intent);
    }
    public void opendistance(){
        Intent intent = new Intent(this,distance.class);
        startActivity(intent);
    }
    public void opentemperature(){
        Intent intent = new Intent(this,temperature.class);
        startActivity(intent);
    }


 }


