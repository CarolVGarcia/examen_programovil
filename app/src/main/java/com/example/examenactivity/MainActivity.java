package com.example.examenactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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
        if(Nombre.getText().toString().isEmpty()) {
            Nombre.setError("El nombre es obligatorio");
            return false;
        }
        if(Base.getText().toString().isEmpty()) {
            Base.setError("La base es obligatoria");
            return false;
        }
        if(Altura.getText().toString().isEmpty()) {
            Altura.setError("La altura es obligatoria");
            return false;
        }
        return true;
    }
}
