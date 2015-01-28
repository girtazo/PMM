package com.example.david.spinnerpesona;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

<<<<<<< HEAD
=======
import java.util.ArrayList;
import java.util.List;

>>>>>>> 98ab39947c27975de8435f2ca1ac9183b780fda5

public class personaSpinner extends Activity {

    private String[] edades = new String[99];
<<<<<<< HEAD
    public static boolean primeraSeleccion = false;

=======
    private boolean selectEdad;
    private boolean selectPersonas;
    private Spinner spinnerEdad;
    private Spinner spinnerPersonas;
    private ArrayList<Persona> personas = new ArrayList<Persona>();
>>>>>>> 98ab39947c27975de8435f2ca1ac9183b780fda5
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persona_spinner);

<<<<<<< HEAD
=======
        //Preparar selecciones
        this.selectEdad = false;
        this.selectPersonas =false;

>>>>>>> 98ab39947c27975de8435f2ca1ac9183b780fda5
        // Contruir Array de Edades
        for(int edad=1;edad<100;edad++){
            this.edades[edad-1] = String.valueOf(edad);
        }

        // Recoger elementos de la interfaz
<<<<<<< HEAD
        Spinner spinnerEdad = (Spinner)findViewById(R.id.spinnerEdad);
        Button enviar = (Button)findViewById(R.id.buttonEnviar);
=======
        spinnerEdad = (Spinner)findViewById(R.id.spinnerEdad);
        Button enviar = (Button)findViewById(R.id.buttonEnviar);
        Button buttonPersona = (Button)findViewById(R.id.buttonPersona);
>>>>>>> 98ab39947c27975de8435f2ca1ac9183b780fda5

        // Cargar Adaptador con XML
        ArrayAdapter<String> adaptadorDesplegable = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, edades);
        adaptadorDesplegable.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEdad.setAdapter(adaptadorDesplegable);
<<<<<<< HEAD

        // Asignar Eventos
=======
        spinnerPersonas = (Spinner) findViewById(R.id.spinnerPersonas);

        // Asignar Eventos
        buttonPersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MostrarDatos = new Intent(personaSpinner.this,Datos.class);
                Bundle datos = new Bundle();

                // Recoger elementos de la interfaz
                EditText editTextnombre = (EditText)findViewById(R.id.editTextNombre);
                EditText editTextapellidos = (EditText)findViewById(R.id.editTextApellidos);

                // Obtenemos datos de la persona
                String nombre = editTextnombre.getText().toString();
                String apellidos = editTextapellidos.getText().toString();
                int edad = Integer.parseInt(spinnerEdad.getSelectedItem().toString());

                // Instanciamos persona
                Persona persona = new Persona(nombre,apellidos,edad);

                personas.add(persona);
                //ArrayAdapter<Persona> adaptadorPersona = new ArrayAdapter<Persona>(personaSpinner.this, android.R.layout.simple_spinner_dropdown_item, personas);
                AdaptadorPersona adaptadorPersona = new AdaptadorPersona(personaSpinner.this,R.layout.lista,personas);

                spinnerPersonas.setAdapter(adaptadorPersona);
            }
        });

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MostrarDatos = new Intent(personaSpinner.this,Datos.class);
                Bundle datos = new Bundle();

                // Obtenemos la persona seleccionada
                int posicion = spinnerPersonas.getSelectedItemPosition();
                Persona persona = personas.get(posicion);

                datos.putSerializable("persona",persona);
                MostrarDatos.putExtras(datos);

                startActivity(MostrarDatos);
            }
        });

>>>>>>> 98ab39947c27975de8435f2ca1ac9183b780fda5
        spinnerEdad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {

<<<<<<< HEAD
                if(personaSpinner.primeraSeleccion){
                    String mensaje = "Usted tiene " + edades[position]+" años";
                    showToast(mensaje);
                } else {
                    personaSpinner.primeraSeleccion = true;
=======
                if(selectEdad){
                    String mensaje = "Usted tiene " + edades[position]+" años";
                    showToast(mensaje);
                } else {
                    selectEdad = true;
>>>>>>> 98ab39947c27975de8435f2ca1ac9183b780fda5
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
<<<<<<< HEAD

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MostrarDatos = new Intent(personaSpinner.this,Datos.class);
                Bundle datos = new Bundle();
                EditText editTextnombre = (EditText)findViewById(R.id.editTextNombre);
                EditText editTextapellidos = (EditText)findViewById(R.id.editTextApellidos);
                Spinner spinnerEdad = (Spinner)findViewById(R.id.spinnerEdad);
                String nombre = editTextnombre.getText().toString();
                String apellidos = editTextapellidos.getText().toString();
                int edad = Integer.parseInt(spinnerEdad.getSelectedItem().toString());
                Persona persona = new Persona(nombre,apellidos,edad);
                datos.putSerializable("persona",persona);
                MostrarDatos.putExtras(datos);
                startActivity(MostrarDatos);
=======
        spinnerPersonas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {

                if(selectPersonas){
                    spinnerPersonas.setPrompt(personas.get(position).getNombre());
                } else {
                    selectPersonas = true;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

>>>>>>> 98ab39947c27975de8435f2ca1ac9183b780fda5
            }
        });
    }
    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.persona_spinner, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
