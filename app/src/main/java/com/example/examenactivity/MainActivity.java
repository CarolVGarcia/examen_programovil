package com.example.examenactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText Nombre, Base, Altura;
    private Button btnLimpiar, btnSiguiente, btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nombre = findViewById(R.id.txtNombre);
        Base = findViewById(R.id.txtBase);
        Altura = findViewById(R.id.txtAltura);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnSiguiente = findViewById(R.id.btnSiguiente);
        btnSalir = findViewById(R.id.btnSalir);

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Nombre.setText("");
                Base.setText("");
                Altura.setText("");
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validarCampos()) {
                    Intent intent = new Intent(MainActivity.this, RectanguloActivity.class);
                    intent.putExtra("NOMBRE", Nombre.getText().toString());
                    intent.putExtra("BASE", Float.parseFloat(Base.getText().toString()));
                    intent.putExtra("ALTURA", Float.parseFloat(Altura.getText().toString()));
                    startActivity(intent);
                }
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private boolean validarCampos() {
        boolean valid = true;
        if(Nombre.getText().toString().isEmpty()) {
            Nombre.setError("El nombre es obligatorio");
            valid = false;
        }
        if(Base.getText().toString().isEmpty()) {
            Base.setError("La base es obligatoria");
            valid = false;
        }
        if(Altura.getText().toString().isEmpty()) {
            Altura.setError("La altura es obligatoria");
            valid = false;
        }
        return valid;
    }
}
