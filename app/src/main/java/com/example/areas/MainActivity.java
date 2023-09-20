package com.example.areas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Spinner spinner ;
    EditText R_height,R_width,radius,base,c_height;
    TextView textView;
    Button button ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner=findViewById(R.id.spinner);
        R_height=findViewById(R.id.editTextNumberDecimal);
        R_width=findViewById(R.id.editTextNumberDecimal2);
        radius=findViewById(R.id.editTextNumberDecimal3);
        base=findViewById(R.id.editTextNumberDecimal5);
        c_height=findViewById(R.id.editTextNumberDecimal7);
        textView=findViewById(R.id.textView);
        button=findViewById(R.id.button);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0 :
                        R_height.setVisibility(view.VISIBLE);
                        R_width.setVisibility(view.VISIBLE);
                        radius.setVisibility(view.GONE);
                        base.setVisibility(view.GONE);
                        c_height.setVisibility(view.GONE);
                        break ;
                    case 1 :
                        R_height.setVisibility(view.GONE);
                        R_width.setVisibility(view.GONE);
                        radius.setVisibility(view.VISIBLE);
                        base.setVisibility(view.GONE);
                        c_height.setVisibility(view.GONE);
                        break ;
                    case 2 :
                        R_height.setVisibility(view.GONE);
                        R_width.setVisibility(view.GONE);
                        radius.setVisibility(view.GONE);
                        base.setVisibility(view.VISIBLE);
                        c_height.setVisibility(view.VISIBLE);
                        break ;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(spinner.getSelectedItemPosition()){
                    case 0 :
                        textView.setText((Double.parseDouble(R_height.getText().toString())*
                                Double.parseDouble(R_width.getText().toString()))+"");
                        break ;
                    case 1 :
                        textView.setText(Double.parseDouble(radius.getText().toString())*Double.parseDouble(radius.getText().toString())*3.14 +"");
                        break ;
                    case 2 :
                        textView.setText((Double.parseDouble(base.getText().toString())*0.5*
                                Double.parseDouble(c_height.getText().toString()))+"");
                        break ;
                }
            }
        });
    }
}