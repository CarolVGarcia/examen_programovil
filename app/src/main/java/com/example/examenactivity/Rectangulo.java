package com.example.examenactivity;

public class Rectangulo {
    private float base;
    private float altura;

    public Rectangulo(float base, float altura) {
        this.base = base;
        this.altura = altura;
    }

    public Rectangulo(){
        this.base = 0.0f;
        this.altura = 0.0f;
    }

    public float calculoArea() {
        return base * altura;
    }

    public float calculoPerimetro() {
        return 2 * (base + altura);
    }

    public float getBase() {
        return base;
    }

    public void setBase(float base) {
        this.base = base;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }
}
