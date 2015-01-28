package com.example.david.spinnerpesona;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.Serializable;


public class Datos extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);
        Bundle datos = getIntent().getExtras();
        TextView nombre = (TextView)findViewById(R.id.textViewNombreValue);
        TextView apellidos = (TextView)findViewById(R.id.textViewApellidosValue);
        TextView edad = (TextView)findViewById(R.id.textViewEdadValue);
        Persona persona = (Persona) datos.getSerializable("persona");
<<<<<<< HEAD
        nombre.setText(persona.nombre);
        apellidos.setText(persona.apellidos);
        edad.setText(String.valueOf(persona.edad));
=======
        nombre.setText(persona.getNombre());
        apellidos.setText(persona.getApellidos());
        edad.setText(String.valueOf(persona.getEdad()));
>>>>>>> 98ab39947c27975de8435f2ca1ac9183b780fda5
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.datos, menu);
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
