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

public class ComfirmaDatos extends AppCompatActivity {


    private TextView tvNameFinal;
    private TextView tvDateFinal;
    private TextView tvPhoneFinal;
    private TextView tvEmailFinal;
    private TextView tvDescFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comfirma_datos);

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString("Nombre Completo");
        String fecha = parametros.getString("Set Date");
        String telefono = parametros.getString("Telefono");
        String email = parametros.getString("Email");
        String desc = parametros.getString("Descrip");

        tvNameFinal=(TextView) findViewById(R.id.tvNameFinal);
        tvDateFinal = (TextView) findViewById(R.id.tvDateFinal);
        tvPhoneFinal = (TextView) findViewById(R.id.tvPhoneFinal);
        tvEmailFinal = (TextView) findViewById(R.id.tvEmailFinal);
        tvDescFinal = (TextView) findViewById(R.id.tvDescFinal);

        tvNameFinal.setText("Nombre:" + nombre);
        tvDateFinal.setText("Fecha de Naciemiento:" + fecha);
        tvPhoneFinal.setText("Tel.:" + telefono);
        tvEmailFinal.setText("Email:" + email);
        tvDescFinal.setText("Descripción:" + desc);



        Button orderButtonEdit = (Button)findViewById(R.id.btnEdit);

        //--- BOTON QUE REDIRECCIONA A OTRA ACTIVIDAD--//
        orderButtonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //       Intent intent = new Intent(FirstActivity.this, OrderScreen.class);
                Intent nextbtn = new Intent(ComfirmaDatos.this, MainActivity.class);

                startActivity(nextbtn);

            }
        });
//End button

    }



    }

