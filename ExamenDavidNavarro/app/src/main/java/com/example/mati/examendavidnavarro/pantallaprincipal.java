package com.example.mati.examendavidnavarro;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;


public class pantallaprincipal extends Activity {

    private Spinner spinnerZonas;
    private String zona;
    private DB database;

    public void showToast(String text){
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantallaprincipal);

        spinnerZonas = (Spinner) findViewById(R.id.zonas);
        Button btnCalcula = (Button) findViewById(R.id.btnCalcula);

        Destino[] zonas = new Destino[3];

        zonas[0] = new Destino("Zona A", "Europa", 10);
        zonas[1] = new Destino("Zona B", "Asia y Oceania", 30);
        zonas[2] = new Destino("Zona C", "America y Africa", 20);

        AdapterZona adap = new AdapterZona(this, zonas);
        spinnerZonas.setAdapter(adap);

        database= new DB(this, "dbexam", null, 1);

        btnCalcula.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                float costeFinal = 0;
                float precioPeso = 0;
                int precioZona = 0;
                String tarifa = "normal";
                float incremento = 1;

                RadioGroup grupo = (RadioGroup) findViewById(R.id.envio);
                CheckBox caja = (CheckBox) findViewById(R.id.caja);
                CheckBox tarjeta = (CheckBox)findViewById(R.id.tarjeta);
                EditText editPeso = (EditText) findViewById(R.id.peso);

                if (grupo.getCheckedRadioButtonId() == R.id.urgente )
                {
                        incremento = (float) 1.30;
                }

                int peso = Integer.parseInt(editPeso.getText().toString());
                if( peso >= 10){

                    precioPeso = 2;
                } else if( peso >= 6 ){

                    precioPeso = (float) 1.5;
                } else {

                    precioPeso = 1;
                }

                Destino destino = (Destino)spinnerZonas.getSelectedItem();

                zona = destino.getZona();

                if (zona.equals("Zona A")) {
                    precioZona = 30;

                } else if (zona.equals("Zona B")) {
                    precioZona = 20;

                } else if (zona.equals("Zona C")) {
                    precioZona = 10;

                }

                costeFinal = ((precioPeso * peso)+precioZona)*incremento;



                // Obtenemos conexion
                SQLiteDatabase conexion = database.getWritableDatabase();

                // Comprobar conexion
                if (conexion!=null) {

                    // Creamos los datos
                    ContentValues paquete = new ContentValues();
                    paquete.put("zona",zona);
                    paquete.put("costeFinal",costeFinal);

                    //Introducimos los datos en la tabla Clientes
                    conexion.insert("dbzona", null, paquete);

                }

                showToast("Se ha insertado el registro del calculo");

                Intent MostrarZona = new Intent(pantallaprincipal.this,mostrarzona.class);
                Bundle datos = new Bundle();

                datos.putString("zona",zona);
                datos.putInt("precioZona",precioZona);
                datos.putString("tarifa",tarifa);
                datos.putInt("peso", peso);
                datos.putFloat("precioPeso",precioPeso);
                datos.putFloat("incremento",incremento);

                MostrarZona.putExtras(datos);
                startActivity(MostrarZona);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.pantallaprincipal, menu);
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
