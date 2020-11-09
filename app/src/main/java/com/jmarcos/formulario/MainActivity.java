package com.jmarcos.formulario;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

import static android.app.PendingIntent.getActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int REQUEST_CODE=1;
    EditText fecha;
    Button bfecha;
    Button siguiente;
    EditText etnombre,ettelefono,etemail,etdescripcion;
    private  int dia,mes,ano;
    private String nombre,correo,descripcionContacto,fecha2,telefono;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bfecha = (Button) findViewById(R.id.btnFecha);
        bfecha.setOnClickListener(this);
        siguiente = (Button) findViewById(R.id.btnSiguiente);
        siguiente.setOnClickListener(this);

        fecha = (EditText) findViewById(R.id.etFecha);
        etnombre = (EditText) findViewById(R.id.etNombre);
        ettelefono = (EditText) findViewById(R.id.etPhone);
        etemail = (EditText) findViewById(R.id.etEmailAddress);
        etdescripcion = (EditText) findViewById(R.id.descripcionContacto);


    }


    @Override
    public void onClick(View v) {
        if (v==bfecha){
            final  Calendar c=Calendar.getInstance();
            dia=c.get(Calendar.DAY_OF_MONTH);
            mes=c.get(Calendar.MONTH);
            ano=c.get(Calendar.YEAR);
            DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    fecha.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                }
            },ano,dia,mes);
            datePickerDialog.show();
        }
        if (v==siguiente){
            VariablesFormulario variablesFormulario =new VariablesFormulario();
            variablesFormulario.setNombre(etnombre.getText().toString());
            variablesFormulario.setFecha(fecha.getText().toString());
            variablesFormulario.setTelefono(ettelefono.getText().toString());
            variablesFormulario.setEmail(etemail.getText().toString());
            variablesFormulario.setDescripcionContacto(etdescripcion.getText().toString());

            Intent intent=new Intent(MainActivity.this,ConfirmarDatos.class);
            intent.putExtra("nombre",variablesFormulario.getNombre());
            intent.putExtra("fecha",variablesFormulario.getFecha());
            intent.putExtra("telefono",variablesFormulario.getTelefono());
            intent.putExtra("email",variablesFormulario.getEmail());
            intent.putExtra("descripcion",variablesFormulario.getDescripcionContacto());


            startActivityForResult(intent,REQUEST_CODE);

        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST_CODE){
            if (requestCode==RESULT_OK) {
                etnombre.setText(data.getExtras().getString("cNombre"));
                fecha.setText(data.getExtras().getString("cFecha"));
                etemail.setText(data.getExtras().getString("cEmail"));
                ettelefono.setText(data.getExtras().getString("cTelefono"));
                etdescripcion.setText(data.getExtras().getString("cDescripcion"));

            }

        }
    }

    }
