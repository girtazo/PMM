package com.example.david.comunicacionentreactivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Pantalla3 extends Activity {

    // Interfaz grafica
    private Button btnPantalla1;
    private TextView contenido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla3);

        // Recoger Elementos graficos
        this.btnPantalla1 = (Button) findViewById(R.id.boton);
        this.contenido = (TextView)findViewById(R.id.contenido);

        this.btnPantalla1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent cambioActivity = new Intent(Pantalla3.this,Pantalla1.class);
                        Bundle datos = new Bundle();
                        datos.putString("mensaje","Pantalla1, vuelta de la pantalla3");
                        cambioActivity.putExtras(datos);
                        setResult (RESULT_OK,cambioActivity);
                        finish();
                    }
                }
        );
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.pantalla2, menu);
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
