package sg.edu.rp.c346.id21006564.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    Button btnDemo1,btnDemo2,btnDemo3,btnDemoEx3,btnDemo4,btnDemo5;
    TextView tvDemo2,tvDemo3 ,tvDemoEx3,tvDemo4,tvDemo5;
    EditText etInput,etN1,etN2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDemo1=findViewById(R.id.btnDemo1);
        btnDemo2 = findViewById(R.id.btnDemo2);
        tvDemo2 = findViewById(R.id.tvDemo2);
        btnDemo3 = findViewById(R.id.btnDemo3);
        tvDemo3 = findViewById(R.id.tvDemo3);
        etInput = findViewById(R.id.editTextInput);
        btnDemoEx3 = findViewById(R.id.btnDemoEx3);
        tvDemoEx3 = findViewById(R.id.tvDemoEx3);
        etN1 = findViewById(R.id.etN1);
        etN2 = findViewById(R.id.etN2);
        btnDemo4=findViewById(R.id.btnDemo4);
        btnDemo5=findViewById(R.id.btnDemo5);
        tvDemo4=findViewById(R.id.tvDemo4);
        tvDemo5=findViewById(R.id.tvDemo5);

        btnDemo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                   //set the dialog details
                /*myBuilder.setTitle("Demo 1-Simple Dialog");
                myBuilder.setMessage("I can develop Android App.");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("close",null);
                */
                myBuilder.setTitle("Congratulations");
                myBuilder.setMessage("You have completed a simple Dialog Box.");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("DISMISS",null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });
        btnDemo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                myBuilder.setTitle("Demo 2 Buttons Dialog");
                myBuilder.setMessage("Select one of the Buttons below.");
                myBuilder.setCancelable(false);
                //positive button configure
                myBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("You have selected YES.");

                    }
                });
                myBuilder.setNegativeButton("N0", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                            tvDemo2.setText("You have selected NO");
                    }
                });
                myBuilder.setNeutralButton("Cancel",null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });
        btnDemo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //inflate the xml layout file.
                LayoutInflater inflater =
                        (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input,null);
                //
                final EditText etInput = viewDialog.findViewById(R.id.editTextInput);
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Demo 3-Text Input Dialog");

                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Extract the text entered by the user
                        String message = etInput.getText().toString();
                        // Set the text to the TextView
                        tvDemo3.setText(message);

                    }
                });
                myBuilder.setNegativeButton("CANCEL",null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });
        btnDemoEx3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.sum,null);

                final EditText etN1 = viewDialog.findViewById(R.id.etN1);
                final EditText etN2 = viewDialog.findViewById(R.id.etN2);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);  // Set the view of the dialog
                myBuilder.setTitle("Exercise 3 ");
                myBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
              int message = Integer.parseInt(etN1.getText().toString())+ Integer.parseInt(etN2.getText().toString());

                        //String sum = ;
                       // String message =sum.getText.toString();
                       tvDemoEx3.setText("The sum is "+ message);

                    }
                });
                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

            }
                    });
        btnDemo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        tvDemo4.setText("Date: "+ dayOfMonth+"/"+(monthOfYear+1)+ "/"+year);
                    }
                };
                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this,myDateListener,2013,11,31);
                myDateDialog.show();
            }
        });

        btnDemo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        tvDemo5.setText("Time: "+ hourOfDay+":"+minute);
                    }
                };
                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this,myTimeListener,20,00,true);
                myTimeDialog.show();
            }
        });


    }
}