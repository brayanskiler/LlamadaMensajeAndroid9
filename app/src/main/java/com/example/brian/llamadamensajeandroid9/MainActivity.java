package com.example.brian.llamadamensajeandroid9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnAceptar;
    EditText txtMensaje;
    EditText txtNumero;

    public static Intent intent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAceptar = findViewById(R.id.btnAceptar);
        txtMensaje = findViewById(R.id.txtMensaje);
        txtNumero = findViewById(R.id.txtNumero);

        btnAceptar.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {



                intent.putExtra("NumeroTelefonico", txtNumero.getText().toString());
                intent.putExtra("MensajeTexto", txtMensaje.getText().toString());

                Toast.makeText(MainActivity.this, intent.getExtras().getString("NumeroTelefonico") + " ACTIVITY", Toast.LENGTH_LONG).show();



                //SharedPreferences sharedPreferences = getSharedPreferences("datosEnvio", getApplication().MODE_PRIVATE);
                //SharedPreferences.Editor editor = sharedPreferences.edit();
                //editor.putString("NumeroTelefono", txtNumero.getText().toString());
                //editor.putString("MensajeTexto", txtMensaje.getText().toString());
                //editor.commit();

            }
        });



    }
}
