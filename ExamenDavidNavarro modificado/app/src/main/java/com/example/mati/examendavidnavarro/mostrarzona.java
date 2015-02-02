package com.example.mati.examendavidnavarro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class mostrarzona extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrarzona);

        String msgdecoracion = "";
        Bundle datos = getIntent().getExtras();
        String zona = datos.getString("zona");
        Integer precioZona = datos.getInt("precioZona");
        Integer peso = datos.getInt("peso");
        String tarifa = datos.getString("tarifa");
        Float precioPeso = datos.getFloat("precioPeso");
        Float incremento = datos.getFloat("incremento");
        Boolean tarjeta = datos.getBoolean("tarjeta");
        Boolean caja = datos.getBoolean("caja");
        Float costeFinal = datos.getFloat("costeFinal");

        TextView textzona = (TextView) findViewById(R.id.zona);
        TextView texttarifa = (TextView) findViewById(R.id.tarifa);
        TextView textpeso = (TextView) findViewById(R.id.peso);
        TextView textdecoracion = (TextView) findViewById(R.id.decoracion);
        TextView textcoste = (TextView) findViewById(R.id.coste);
        ImageView imagenzona = (ImageView) findViewById(R.id.imagenzona);

        if (zona.equals("Zona A")) {
            imagenzona.setImageResource(R.drawable.europa);

        } else if (zona.equals("Zona B")) {
            imagenzona.setImageResource(R.drawable.asia_oceania);

        } else if (zona.equals("Zona C")) {
            imagenzona.setImageResource(R.drawable.america_africa);

        }

        textzona.setText(zona);
        texttarifa.setText("Tarifa " + tarifa);
        textpeso.setText("Peso: "+peso.toString() + "Kg");


        if (caja) {

            msgdecoracion = msgdecoracion + "Decoracion: Con caja regalo ";
        } else if (tarjeta) {

            msgdecoracion = msgdecoracion + "Decoracion: Con dedicadoria";
            tarjeta = false;
        }

        if(tarjeta) {

            msgdecoracion = msgdecoracion + "y dedicadoria";
        }

        textdecoracion.setText(msgdecoracion);

        textcoste.setText("COSTE FINAL: "+costeFinal.toString()+ "€");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mostrarzona, menu);
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
        } else if(id == R.id.action_Azafata){

            Intent MostrarAzafata = new Intent(mostrarzona.this,dibujo.class);
            startActivity(MostrarAzafata);
        }
        return super.onOptionsItemSelected(item);
    }
}
