package com.example.convertor_l;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class temperature extends AppCompatActivity {

    Spinner tsp1,tsp2;
    EditText ted1;
    Button tb1;
    TextView tt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        ted1 = findViewById(R.id.txttemp);
        tsp1 = findViewById(R.id.sptfrom);
        tsp2 = findViewById(R.id.sptto);
        tb1 = findViewById(R.id.tbt1);
        tt1 = findViewById(R.id.result3);

        String[] from = {"C", "F", "K"};
        ArrayAdapter cd = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, from);
        tsp1.setAdapter(cd);

        String[] to = {"C", "F", "K"};
        ArrayAdapter cd1 = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, to);
        tsp2.setAdapter(cd1);

        tb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(ted1.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(),"Enter the value".toString(),Toast.LENGTH_LONG).show();


                }

                else {

                    Double cot;
                    Double tis = Double.parseDouble(ted1.getText().toString());

                    if (tsp1.getSelectedItem().toString() == tsp2.getSelectedItem().toString()) {
                        Toast.makeText(getApplicationContext(), "Cannot convert same Units".toString(), Toast.LENGTH_LONG).show();
                    } else if (tsp1.getSelectedItem().toString() == "C" && tsp2.getSelectedItem().toString() == "K") {
                        cot = tis + 273.5;
                        tt1.setText(cot.toString());
                    } else if (tsp1.getSelectedItem().toString() == "C" && tsp2.getSelectedItem().toString() == "F") {
                        cot = (tis * 9 / 5) + 32;
                        tt1.setText(cot.toString());
                    } else if (tsp1.getSelectedItem().toString() == "F" && tsp2.getSelectedItem().toString() == "K") {
                        cot = ((tis - 32) * 5 / 9) + 273.15;
                        tt1.setText(cot.toString());
                    } else if (tsp1.getSelectedItem().toString() == "F" && tsp2.getSelectedItem().toString() == "C") {
                        cot = (tis - 32) * 5 / 9;
                        tt1.setText(cot.toString());
                    } else if (tsp1.getSelectedItem().toString() == "K" && tsp2.getSelectedItem().toString() == "C") {
                        cot = tis - 273.15;
                        tt1.setText(cot.toString());
                    } else if (tsp1.getSelectedItem().toString() == "K" && tsp2.getSelectedItem().toString() == "F") {
                        cot = (tis - 273.15) * 9 / 5 + 32;
                        tt1.setText(cot.toString());
                    }
                }

            }

        });
    }

}

