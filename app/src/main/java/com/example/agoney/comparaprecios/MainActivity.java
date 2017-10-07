package com.example.agoney.comparaprecios;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Activity contexto; // actividad que almacenará esta misma actividad.
    ClaseComun comun;  // referencia a ese objeto que no desaparece.
    // ArrayList<Producto> productos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contexto=this;
       // comun = new ClaseComun();
        // productos=(ArrayList<Producto>) comun.getProductos();
       //  ClaseComun comun = (ClaseComun) getApplication();  // referencia a ese objeto que no desaparece.
        // creo los objetos de los view
        Button btnInfo = (Button) findViewById(R.id.btn_info);
        Button btnProductos = (Button) findViewById(R.id.btn_productos);
        Button btnLista = (Button) findViewById(R.id.btn_lista);
        Button btnSalir = (Button) findViewById(R.id.btn_salir);

        btnInfo.setOnClickListener(new View.OnClickListener() {  // Listener del botón Info
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(contexto, ActivityInfo.class); // creamos el intento, de donde viene y a donde va
            //  intent.setExtrasClassLoader("productos", productos );
                startActivity(intent); // ejecuta el intento.
            }
        });  // cerramos el click listener
        btnSalir.setOnClickListener(new View.OnClickListener() { // Listener del botón Salir
            @Override
            public void onClick(View view) {
                setResult(RESULT_OK);
                finish();
            }
        });  // cerramos el click listener
        btnProductos.setOnClickListener(new View.OnClickListener() { // Listener del botón Productos
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(contexto, ActivityProductos.class); // creamos el intento, de donde viene y a donde va
                // intent.setExtrasClassLoader("comun", comun);
                startActivity(intent); // ejecuta el intento.
            }
        });  // cerramos el click listener
        btnLista.setOnClickListener(new View.OnClickListener() { // Listener del botón Lista
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(contexto, ActivityLista.class); // creamos el intento, de donde viene y a donde va
                startActivity(intent); // ejecuta el intento.
            }
        });  // cerramos el click listener

    }
}
