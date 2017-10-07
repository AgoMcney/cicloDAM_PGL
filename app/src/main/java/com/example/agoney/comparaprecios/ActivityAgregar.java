package com.example.agoney.comparaprecios;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.xml.sax.helpers.ParserAdapter;

import java.util.ArrayList;

public class ActivityAgregar extends AppCompatActivity {
    Activity contexto;  // probar getApplicationContext()
    EditText txtInputNombre;
    RadioGroup radioFamilia;
    String familiaSeleccionada=null;
    EditText editTextTienda1, editTextTienda2, editTextTienda3, editTextTienda4, editTextTienda5, editTextTienda6;
    Float precio1, precio2, precio3, precio4, precio5, precio6;
    ClaseComun comun;  // referencia a ese objeto que no desaparece.
    boolean error=false; // controladores de errores
    // ArrayList<Producto> productos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
        contexto = this;
        // instancio las view
        Button btnGuardar = (Button) findViewById(R.id.btnGuardar);
        Button btnCancelar = (Button) findViewById(R.id.btnCancelar);
        txtInputNombre = (EditText) findViewById(R.id.TxtInputNombre);
        ImageButton btnImagen = (ImageButton) findViewById(R.id.imageViewProducto);
        radioFamilia = (RadioGroup) findViewById(R.id.RadioGroupFamilia);
        editTextTienda1 = (EditText) findViewById(R.id.editTextTienda1);
        editTextTienda2 = (EditText) findViewById(R.id.editTextTienda2);
        editTextTienda3 = (EditText) findViewById(R.id.editTextTienda3);
        editTextTienda4 = (EditText) findViewById(R.id.editTextTienda4);
        editTextTienda5 = (EditText) findViewById(R.id.editTextTienda5);
        editTextTienda6 = (EditText) findViewById(R.id.editTextTienda6);
        familiaSeleccionada = getString(R.string.familia12);
    //  productos = (ArrayList<Producto>) getIntent().getSerializableExtra("productos"); // recibo el ArrayList
      // comun = (ClaseComun) getApplication();  // referencia a ese objeto que no desaparece.
        comun = new ClaseComun();  // referencia a ese objeto que no desaparece.
       // comun = (ClaseComun) getApplication() ;  // referencia a ese objeto que no desaparece.
        radioFamilia.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.RadioBtnFamilia1:
                        familiaSeleccionada = getString(R.string.familia1);
                        break;
                    case R.id.RadioBtnFamilia2:
                        familiaSeleccionada = getString(R.string.familia2);
                        break;
                    case R.id.RadioBtnFamilia3:
                        familiaSeleccionada = getString(R.string.familia3);
                        break;
                    case R.id.RadioBtnFamilia4:
                        familiaSeleccionada = getString(R.string.familia4);
                        break;
                    case R.id.RadioBtnFamilia5:
                        familiaSeleccionada = getString(R.string.familia5);
                        break;
                    case R.id.RadioBtnFamilia6:
                        familiaSeleccionada = getString(R.string.familia6);
                        break;
                    case R.id.RadioBtnFamilia7:
                        familiaSeleccionada = getString(R.string.familia7);
                        break;
                    case R.id.RadioBtnFamilia8:
                        familiaSeleccionada = getString(R.string.familia8);
                        break;
                    case R.id.RadioBtnFamilia9:
                        familiaSeleccionada = getString(R.string.familia9);
                        break;
                    case R.id.RadioBtnFamilia10:
                        familiaSeleccionada = getString(R.string.familia10);
                        break;
                    case R.id.RadioBtnFamilia11:
                        familiaSeleccionada = getString(R.string.familia11);
                        break;
                    case R.id.RadioBtnFamilia12:
                        familiaSeleccionada = getString(R.string.familia12);
                        break;
                }
            }
        });
        btnGuardar.setOnClickListener(new View.OnClickListener() {  // Listener del botón Agregar
            @Override
            public void onClick(View view) {
                validar();
                if (error==false)
                AgregarProducto();
          //      Toast.makeText (contexto, "Hay "+ comun .getProductos().size()+" productos.", Toast.LENGTH_SHORT).show();

            }
        });
        btnImagen.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                Toast.makeText(contexto, "En el futuro podrá añadir una imagen aqui", Toast.LENGTH_SHORT).show();
             }
            }
        );
    }
        public void AgregarProducto(){
        Producto nuevo = new Producto(txtInputNombre.getText().toString(), familiaSeleccionada,
                precio1, precio2, precio3, precio4, precio5, precio6);
        // comun.getProductos().add(nuevo);
        //    comun.productos.add(nuevo);
        Toast.makeText (contexto, "El producto se ha guardado. "
                        +nuevo.nombre + " " + nuevo.familia
                        + "\n"+ getString(R.string.tienda1) +  " precio: " +precio1
                        + "\n"+ getString(R.string.tienda2) +  " precio: " +precio2
                        + "\n"+ getString(R.string.tienda3) +  " precio: " +precio3
                        + "\n"+ getString(R.string.tienda4) +  " precio: " +precio4
                        + "\n"+ getString(R.string.tienda5) +  " precio: " +precio5
                        + "\n"+ getString(R.string.tienda6) +  " precio: " +precio6
                ,Toast.LENGTH_LONG).show();
        }
        public void validar(){
            // vacio los errores
            txtInputNombre.setError(null);
            editTextTienda1.setError(null);
            editTextTienda2.setError(null);
            editTextTienda3.setError(null);
            editTextTienda4.setError(null);
            editTextTienda5.setError(null);
            editTextTienda6.setError(null);
            error=false;
            // compruebo cada campo
            if (TextUtils.isEmpty( txtInputNombre.getText())){
                txtInputNombre.setError(getString(R.string.error_obligatorio)); // marcamos el error
                txtInputNombre.requestFocus(); // llevamos el foco al error
                error=true;
            }
            if (TextUtils.isEmpty(editTextTienda1.getText().toString())){
                precio1=0f; // si esta vacío le asigno un 0
                /*
                editTextTienda1.setError(getString(R.string.error_obligatorio)); // marcamos el error
                editTextTienda1.requestFocus(); // llevamos el foco al error
                error=true;
                */
            } else precio1 = Float.parseFloat(editTextTienda1.getText().toString()); // pasar el valor editable a float
            if (TextUtils.isEmpty(editTextTienda2.getText().toString())){
                precio2=0f; // si esta vacío le asigno un 0
                /*
                editTextTienda2.setError(getString(R.string.error_obligatorio)); // marcamos el error
                editTextTienda2.requestFocus(); // llevamos el foco al error
                error=true;
                */
            } else precio2 = Float.parseFloat(editTextTienda2.getText().toString()); // pasar el valor editable a float
            if (TextUtils.isEmpty(editTextTienda3.getText().toString())){
                precio3=0f; // si esta vacío le asigno un 0
                /*
                editTextTienda3.setError(getString(R.string.error_obligatorio)); // marcamos el error
                editTextTienda3.requestFocus(); // llevamos el foco al error
                error=true;
                */
            } else precio3 = Float.parseFloat(editTextTienda3.getText().toString()); // pasar el valor editable a float
            if (TextUtils.isEmpty(editTextTienda4.getText().toString())){
                precio4=0f; // si esta vacío le asigno un 0
                /*
                editTextTienda4.setError(getString(R.string.error_obligatorio)); // marcamos el error
                editTextTienda4.requestFocus(); // llevamos el foco al error
                error=true;
                */
            } else precio4 = Float.parseFloat(editTextTienda4.getText().toString()); // pasar el valor editable a float
            if (TextUtils.isEmpty(editTextTienda5.getText().toString())){
                precio5=0f; // si esta vacío le asigno un 0
                /*
                editTextTienda5.setError(getString(R.string.error_obligatorio)); // marcamos el error
                editTextTienda5.requestFocus(); // llevamos el foco al error
                error=true;
                */
            } else precio5 = Float.parseFloat(editTextTienda5.getText().toString()); // pasar el valor editable a float
            if (TextUtils.isEmpty(editTextTienda6.getText().toString())){
                precio6=0f; // si esta vacío le asigno un 0
                /*
                editTextTienda6.setError(getString(R.string.error_obligatorio)); // marcamos el error
                editTextTienda6.requestFocus(); // llevamos el foco al error
                error=true;
                */
            } else precio6 = Float.parseFloat(editTextTienda6.getText().toString()); // pasar el valor editable a float

        }

    }

