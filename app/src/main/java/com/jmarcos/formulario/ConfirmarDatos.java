package com.jmarcos.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity implements View.OnClickListener {
    Button editar;
    TextView tvnombre;
    TextView tvfecha;
    TextView tvTelefono;
    TextView tvEmail;
    TextView tvDescripcion;
    TextView etNombre;
    String nombre,fecha,telefono,email,descripcion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        Bundle parametros=getIntent().getExtras();
        nombre=parametros.getString("nombre");
        fecha=parametros.getString("fecha");
        telefono=parametros.getString("telefono");
        email=parametros.getString("email");
        descripcion=parametros.getString("descripcion");

        tvnombre=(TextView)findViewById(R.id.tvnombre);
        tvfecha=(TextView)findViewById(R.id.tvfecha);
        tvTelefono=(TextView)findViewById(R.id.tvTelefono);
        tvEmail=(TextView)findViewById(R.id.tvEmail);
        tvDescripcion=(TextView)findViewById(R.id.tvDescripcion);

        tvnombre.setText(nombre);
        tvfecha.setText(fecha);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcion);

        editar=(Button)findViewById(R.id.btnEditar);
        editar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==editar) {
            Intent intent = new Intent(ConfirmarDatos.this, MainActivity.class);
            intent.putExtra("cNombre",nombre);
            intent.putExtra("cFecha",fecha);
            intent.putExtra("cTelefono",telefono);
            intent.putExtra("cEmail",email);
            intent.putExtra("cDescripcion",descripcion);
            setResult(RESULT_OK,intent);

            finish();
        }
    }

}