package com.example.mati.dibujarcirculorectangulo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;


public class EleccionCreacion extends Activity {
    private ArrayList<String> formas  =  new ArrayList<String>();
    private Spinner spinnerFormas;
    private View vistaEleccion;
    private Button btnDibujar;
    private Dibujo recuadro;
    public EditText radio;
    private boolean seleccionforma = false;
    private View zonaCanvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Añadir formas al array
        this.formas.add("Rectangulo");
        this.formas.add("Circulo");

        // Establecer vista
        setContentView(R.layout.activity_eleccion_creacion);

        // Recoger Interfaz
        this.spinnerFormas = (Spinner) findViewById(R.id.forma);
        this.btnDibujar = (Button) findViewById(R.id.btnDibujar);

        // Crear Adaptador
        ArrayAdapter<String> adaptadorForma = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, formas);
        adaptadorForma.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        // Agregar elementos al spinner
        this.spinnerFormas.setAdapter(adaptadorForma);

        //Evento Activity
        this.spinnerFormas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (seleccionforma) {
                    String forma = parent.getSelectedItem().toString();
                    if(forma == "Rectangulo"){
                        EditText editText = (EditText)findViewById(R.id.radio);
                        editText.setVisibility(View.GONE);
                        editText = (EditText) findViewById(R.id.altura);
                        editText.setVisibility(View.VISIBLE);
                        TextView textView = (TextView) findViewById(R.id.textView1);
                        textView.setText("Altura:");
                        textView = (TextView) findViewById(R.id.textView2);
                        textView.setVisibility(View.VISIBLE);
                        editText = (EditText) findViewById(R.id.ancho);
                        editText.setVisibility(View.VISIBLE);
                    } else {
                        EditText editText = (EditText)findViewById(R.id.radio);
                        editText.setVisibility(View.VISIBLE);
                        editText = (EditText) findViewById(R.id.altura);
                        editText.setVisibility(View.GONE);

                        TextView textView = (TextView) findViewById(R.id.textView1);
                        textView.setText("Radio:");
                        editText = (EditText)findViewById(R.id.ancho);
                        editText.setVisibility(View.GONE);
                        textView = (TextView) findViewById(R.id.textView2);
                        textView.setVisibility(View.GONE);
                    }
                } else {
                    seleccionforma = true;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        this.btnDibujar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recuadro = (Dibujo) findViewById(R.id.dibujo);
                Spinner forma=(Spinner)findViewById(R.id.forma);

                Object figura;
                if(forma.getSelectedItem().toString() == "Rectangulo"){
                    EditText editText = (EditText) findViewById(R.id.altura);
                    float alto = Float.parseFloat(editText.getText().toString());
                    editText = (EditText) findViewById(R.id.ancho);
                    float ancho = Float.parseFloat(editText.getText().toString());
                    figura = new Rectangulo(ancho,alto);

                } else {
                    final EditText editText = (EditText) findViewById(R.id.radio);
                    String texto = editText.getText().toString();
                    float radio = Float.parseFloat(texto);
                    figura = new Circulo(radio);
                }
                Canvas canvas = null;
                recuadro.invalidate();
              //  zonaCanvas = new Dibujo(getBaseContext()/*,figura*/);
              //  zonaCanvas.invalidate();
            };
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.eleccion_creacion, menu);
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
