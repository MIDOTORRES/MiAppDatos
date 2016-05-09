package com.miditos.miappdatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Calendar;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvDisplayDate;
    private DatePicker dpResult;
    private Button btnChangeDate;

    private int year;
    private int month;
    private int day;

    private EditText teName;
    private TextView tvDate;
    private EditText tePhone;
    private EditText teEmail;
    private EditText textDesc;


    static final int DATE_DIALOG_ID = 999;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teName = (EditText) findViewById(R.id.teName);
        tvDate = (TextView) findViewById(R.id.tvDate);
        tePhone = (EditText) findViewById(R.id.tePhone);
        teEmail = (EditText) findViewById(R.id.teEmail);
        textDesc=(EditText) findViewById(R.id.textDesc);

        setCurrentDateOnView();
        addListenerOnButton();

        Button orderButton = (Button) findViewById(R.id.btnNext);
        //--- BOTON QUE REDIRECCIONA A OTRA ACTIVIDAD--//
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //       Intent intent = new Intent(FirstActivity.this, OrderScreen.class);
                Intent nextbtn = new Intent(MainActivity.this, ComfirmaDatos.class);
                nextbtn.putExtra("Nombre Completo",teName.getText().toString());
                nextbtn.putExtra("Set Date",tvDate.getText().toString());
                nextbtn.putExtra("Telefono",tePhone.getText().toString());
                nextbtn.putExtra("Email",teEmail.getText().toString());
                nextbtn.putExtra("Descrip",textDesc.getText().toString());


                startActivity(nextbtn);

            }
        });
//End button


    }

    public void setCurrentDateOnView() {

        tvDisplayDate = (TextView) findViewById(R.id.tvDate);
        dpResult = (DatePicker) findViewById(R.id.dpResult);

        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        // set current date into textview
        tvDisplayDate.setText(new StringBuilder()
                // Month is 0 based, just add 1
                .append(month + 1).append("-").append(day).append("-")
                .append(year).append(" "));

        // set current date into datepicker
        dpResult.init(year, month, day, null);

    }

    public void addListenerOnButton() {

        btnChangeDate = (Button) findViewById(R.id.btnChangeDate);

        btnChangeDate.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                showDialog(DATE_DIALOG_ID);

            }

        });

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                // set date picker as current date
                return new DatePickerDialog(this, datePickerListener,
                        year, month,day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener datePickerListener
            = new DatePickerDialog.OnDateSetListener() {

        // when dialog box is closed, below method will be called.
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            year = selectedYear;
            month = selectedMonth;
            day = selectedDay;

            // set selected date into textview
            tvDisplayDate.setText(new StringBuilder().append(month + 1)
                    .append("-").append(day).append("-").append(year)
                    .append(" "));

            // set selected date into datepicker also
            dpResult.init(year, month, day, null);

        }
    };







}
