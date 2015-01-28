package com.example.david.comunicacionentreactivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Pantalla1 extends Activity {

    private Button btnPantalla2;
    private Button btnPantalla3;
    private TextView contenido;
    public static int codigoRespuesta = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Establece Interfaz grafica
        setContentView(R.layout.activity_pantalla1);

        // Recoger Elementos graficos
        this.btnPantalla2 = (Button) findViewById(R.id.boton1);
        this.btnPantalla3 = (Button) findViewById(R.id.boton2);
        this.contenido = (TextView)findViewById(R.id.contenido);

        // Asignar Eventos a los botones
        this.btnPantalla2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent cambioActivity = new Intent(Pantalla1.this,Pantalla2.class);
                        startActivityForResult(cambioActivity,Pantalla1.codigoRespuesta);
                    }
                }
        );

        this.btnPantalla3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent cambioActivity = new Intent(Pantalla1.this,Pantalla3.class);
                        startActivityForResult(cambioActivity,Pantalla1.codigoRespuesta);
                    }
                }
        );
    }
    public void onActivityResult(int codigo_respuesta, int codigo_resultado,Intent cambioActivity){
        if (codigo_resultado== RESULT_OK) {
            Bundle datos = cambioActivity.getExtras();
            this.contenido.setText(datos.getString("mensaje"));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.pantalla1, menu);
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
