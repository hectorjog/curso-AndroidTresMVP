package com.example.contentprovider;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;


public class Contacto extends AppCompatActivity {


    private TextInputEditText emailes;
    private TextInputEditText mensaje;
    private TextInputEditText nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacto);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nombre = (TextInputEditText) findViewById(R.id.inputNombreCompleto);
        emailes = (TextInputEditText) findViewById(R.id.inputCorreoElectronico);
        mensaje = (TextInputEditText) findViewById(R.id.inputDescripcion);
    }

    public void sendMessage(View view) {

        String titulo = "Mensaje desde la appPetagramContentProvider";
        String correo = emailes.getText().toString().trim();
        String msj = nombre.getText().toString().trim() + " " + mensaje.getText().toString().trim();

        EnviarMail enviar = new EnviarMail(this, correo, titulo, msj);
        enviar.execute();
    }
}
