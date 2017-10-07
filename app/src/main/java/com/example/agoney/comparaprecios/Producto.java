package com.example.agoney.comparaprecios;

/**
 * Created by Agoney on 02/10/2017.
 * Pojo de los productos
 */

public class Producto {
    String nombre;
    String familia;
    float precio1, precio2, precio3, precio4, precio5, precio6 ;

    public Producto() { // constuctor vacío
    }

    public Producto(String nombre, String familia, float precio1, float precio2, float precio3, float precio4, float precio5, float precio6) {
        this.nombre = nombre;
        this.familia = familia;
        this.precio1 = precio1;
        this.precio2 = precio2;
        this.precio3 = precio3;
        this.precio4 = precio4;
        this.precio5 = precio5;
        this.precio6 = precio6;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public float getPrecio1() {
        return precio1;
    }

    public void setPrecio1(float precio1) {
        this.precio1 = precio1;
    }

    public float getPrecio2() {
        return precio2;
    }

    public void setPrecio2(float precio2) {
        this.precio2 = precio2;
    }

    public float getPrecio3() {
        return precio3;
    }

    public void setPrecio3(float precio3) {
        this.precio3 = precio3;
    }

    public float getPrecio4() {
        return precio4;
    }

    public void setPrecio4(float precio4) {
        this.precio4 = precio4;
    }

    public float getPrecio5() {
        return precio5;
    }

    public void setPrecio5(float precio5) {
        this.precio5 = precio5;
    }

    public float getPrecio6() {
        return precio6;
    }

    public void setPrecio6(float precio6) {
        this.precio6 = precio6;
    }
}
