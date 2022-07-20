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

public class currency extends AppCompatActivity {

    Spinner sp1,sp2;
    EditText ed1;
    Button b1;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

        ed1 = findViewById(R.id.txtamount);
        sp1 = findViewById(R.id.spfrom);
        sp2 = findViewById(R.id.spto);
        b1 = (Button) findViewById(R.id.cubt1);
        t1 = findViewById(R.id.result1);



        String[] from = {"INR","USD","EUR","YEN"};
        ArrayAdapter ad = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(ad);

        String[] to = {"INR","USD","EUR","YEN"};
        ArrayAdapter ad1 = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,to);
        sp2.setAdapter(ad1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(ed1.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(),"Enter the value".toString(),Toast.LENGTH_LONG).show();


                }

                else {

                    Double tot;
                    Double amount = Double.parseDouble(ed1.getText().toString());

                    if (sp1.getSelectedItem().toString() == sp2.getSelectedItem().toString()) {
                        Toast.makeText(getApplicationContext(), "Cannot convert same currency".toString(), Toast.LENGTH_LONG).show();
                    } else if (sp1.getSelectedItem().toString() == "INR" && sp2.getSelectedItem().toString() == "USD") {
                        tot = amount * 0.013;
                        t1.setText(tot.toString());
                    } else if (sp1.getSelectedItem().toString() == "INR" && sp2.getSelectedItem().toString() == "EUR") {
                        tot = amount * 0.012;
                        t1.setText(tot.toString());
                    } else if (sp1.getSelectedItem().toString() == "INR" && sp2.getSelectedItem().toString() == "YEN") {
                        tot = amount * 1.41;
                        t1.setText(tot.toString());
                    } else if (sp1.getSelectedItem().toString() == "USD" && sp2.getSelectedItem().toString() == "INR") {
                        tot = amount * 75.05;
                        t1.setText(tot.toString());
                    } else if (sp1.getSelectedItem().toString() == "USD" && sp2.getSelectedItem().toString() == "EUR") {
                        tot = amount * 0.88;
                        t1.setText(tot.toString());
                    } else if (sp1.getSelectedItem().toString() == "USD" && sp2.getSelectedItem().toString() == "YEN") {
                        tot = amount * 113.37;
                        t1.setText(tot.toString());
                    } else if (sp1.getSelectedItem().toString() == "EUR" && sp2.getSelectedItem().toString() == "USD") {
                        tot = amount * 1.13;
                        t1.setText(tot.toString());
                    } else if (sp1.getSelectedItem().toString() == "EUR" && sp2.getSelectedItem().toString() == "INR") {
                        tot = amount * 84.98;
                        t1.setText(tot.toString());
                    } else if (sp1.getSelectedItem().toString() == "EUR" && sp2.getSelectedItem().toString() == "YEN") {
                        tot = amount * 128.27;
                        t1.setText(tot.toString());
                    } else if (sp1.getSelectedItem().toString() == "YEN" && sp2.getSelectedItem().toString() == "USD") {
                        tot = amount * 0.0088;
                        t1.setText(tot.toString());
                    } else if (sp1.getSelectedItem().toString() == "YEN" && sp2.getSelectedItem().toString() == "EUR") {
                        tot = amount * 0.0078;
                        t1.setText(tot.toString());
                    } else if (sp1.getSelectedItem().toString() == "YEN" && sp2.getSelectedItem().toString() == "INR") {
                        tot = amount * 0.66;
                        t1.setText(tot.toString());
                    }

                }


            }
        });
    }
}