package com.maria.spinnersimple;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;


public class SpinnerSimple extends Activity {

    private String[] edades = new String[99];
    private Spinner spinnerEdad = (Spinner)findViewById(R.id.spinnerEdad);

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_simple);

        // Contruir Array de Edades
        for(int edad=1;edad<100;edad++){
            this.edades[edad-1] = String.valueOf(edad);
        }
        // Cargar Adaptador con XML
        ArrayAdapter<String> adaptadorDesplegable = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, edades);
        adaptadorDesplegable.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerEdad.setAdapter(adaptadorDesplegable);
        this.spinnerEdad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {
                EditText editTextnombre = (EditText)findViewById(R.id.editTextNombre);
                EditText editTextapellidos = (EditText)findViewById(R.id.editTextApellidos);
                String mensaje = "Item clicked => " + edades[position];
                showToast(mensaje);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                
            }
        });
    }
    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
