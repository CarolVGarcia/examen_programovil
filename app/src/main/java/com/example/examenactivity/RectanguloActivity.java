package com.example.examenactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class RectanguloActivity extends AppCompatActivity {

    private TextView Nombre, Base, Altura, Resultado;
    private RadioButton rdbArea, rdbPerimetro;
    private Button btnCalcular, btnRegresar;
    private Rectangulo rectangulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangulo);

        Nombre = findViewById(R.id.txtNombre);
        Base = findViewById(R.id.txtBase);
        Altura = findViewById(R.id.txtAltura);
        Resultado = findViewById(R.id.txtResultado);
        rdbArea = findViewById(R.id.rdbArea);
        rdbPerimetro = findViewById(R.id.rdbPerimetro);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnRegresar = findViewById(R.id.btnRegresar);


        float base = getIntent().getFloatExtra("BASE", 0);
        float altura = getIntent().getFloatExtra("ALTURA", 0);
        String nombre = getIntent().getStringExtra("NOMBRE");

        rectangulo = new Rectangulo(base, altura);


        Nombre.setText(nombre);
        Base.setText(String.format("Base: %.2f", base));
        Altura.setText(String.format("Altura: %.2f", altura));

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rdbArea.isChecked()) {
                    float area = rectangulo.calculoArea();
                    Resultado.setText(String.format("Área: %.2f", area));
                } else if(rdbPerimetro.isChecked()) {
                    float perimetro = rectangulo.calculoPerimetro();
                    Resultado.setText(String.format("Perímetro: %.2f", perimetro));
                }
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
