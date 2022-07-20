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

public class distance extends AppCompatActivity {

    Spinner vsp1,vsp2;
    EditText ved1;
    Button vb1;
    TextView vt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance);

        ved1 = findViewById(R.id.txtvalue);
        vsp1 = findViewById(R.id.spvfrom);
        vsp2 = findViewById(R.id.spvto);
        vb1 = findViewById(R.id.dibt1);
        vt1 = findViewById(R.id.result2);


        String[] from = {"Km","Metre","Cm","Miles"};
        ArrayAdapter bd = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,from);
        vsp1.setAdapter(bd);

        String[] to = {"Km","Metre","Cm","Miles"};
        ArrayAdapter bd1 = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,to);
        vsp2.setAdapter(bd1);

        vb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(ved1.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(),"Enter the value".toString(),Toast.LENGTH_LONG).show();


                }

                else {

                    Double vot;
                    Double dis = Double.parseDouble(ved1.getText().toString());

                    if (vsp1.getSelectedItem().toString() == vsp2.getSelectedItem().toString()) {
                        Toast.makeText(getApplicationContext(), "Cannot convert same Units".toString(), Toast.LENGTH_LONG).show();
                    } else if (vsp1.getSelectedItem().toString() == "Km" && vsp2.getSelectedItem().toString() == "Metre") {
                        vot = dis * 1000;
                        vt1.setText(vot.toString());
                    } else if (vsp1.getSelectedItem().toString() == "Km" && vsp2.getSelectedItem().toString() == "Cm") {
                        vot = dis * 100000;
                        vt1.setText(vot.toString());
                    } else if (vsp1.getSelectedItem().toString() == "Km" && vsp2.getSelectedItem().toString() == "Miles") {
                        vot = dis * 0.621;
                        vt1.setText(vot.toString());
                    } else if (vsp1.getSelectedItem().toString() == "Metre" && vsp2.getSelectedItem().toString() == "Km") {
                        vot = dis * 0.001;
                        vt1.setText(vot.toString());
                    } else if (vsp1.getSelectedItem().toString() == "Metre" && vsp2.getSelectedItem().toString() == "Cm") {
                        vot = dis * 100;
                        vt1.setText(vot.toString());
                    } else if (vsp1.getSelectedItem().toString() == "Metre" && vsp2.getSelectedItem().toString() == "Miles") {
                        vot = dis * 0.000621;
                        vt1.setText(vot.toString());
                    } else if (vsp1.getSelectedItem().toString() == "Cm" && vsp2.getSelectedItem().toString() == "Km") {
                        vot = dis * 0.00001;
                        vt1.setText(vot.toString());
                    } else if (vsp1.getSelectedItem().toString() == "Cm" && vsp2.getSelectedItem().toString() == "Metre") {
                        vot = dis * 0.001;
                        vt1.setText(vot.toString());
                    } else if (vsp1.getSelectedItem().toString() == "Cm" && vsp2.getSelectedItem().toString() == "Miles") {
                        vot = dis * 0.000000006;
                        vt1.setText(vot.toString());
                    } else if (vsp1.getSelectedItem().toString() == "Miles" && vsp2.getSelectedItem().toString() == "Km") {
                        vot = dis * 1.60;
                        vt1.setText(vot.toString());
                    } else if (vsp1.getSelectedItem().toString() == "Miles" && vsp2.getSelectedItem().toString() == "Cm") {
                        vot = dis * 160934;
                        vt1.setText(vot.toString());
                    } else if (vsp1.getSelectedItem().toString() == "Miles" && vsp2.getSelectedItem().toString() == "Metre") {
                        vot = dis * 1609.34;
                        vt1.setText(vot.toString());
                    }


                }


            }
        });


    }
}