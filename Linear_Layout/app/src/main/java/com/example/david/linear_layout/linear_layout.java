package com.example.david.linear_layout;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class linear_layout extends Activity {
    private RadioButton blanco;
    private RadioButton red;
    private RadioButton blue;
    private Button set;
    private Button borrar;
    private RadioGroup grupo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Establecer interfaz
        setContentView(R.layout.activity_linear_layout);

        // Recoger elementos de la interfaz
        this.set = (Button) findViewById(R.id.button);
        this.borrar = (Button) findViewById(R.id.button2);

        // Asignar eventos a los elementos de la interfaz

        this.set.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        RadioGroup grupo = (RadioGroup) findViewById(R.id.grupo);
                        TextView fondo = (TextView) findViewById(R.id.textView);
                        switch (grupo.getCheckedRadioButtonId())
                        {
                            case R.id.radioButton:
                               fondo.setBackgroundColor(Color.rgb(255,255,255));
                                break;
                            case R.id.radioButton2:
                                fondo.setBackgroundColor(Color.rgb(255,0,0));
                                break;
                            case R.id.radioButton3:
                                fondo.setBackgroundColor(Color.rgb(0,0,255));
                                break;
                        }
                    }
                }
        );

        this.borrar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TextView fondo = (TextView) findViewById(R.id.textView);
                        fondo.setBackgroundColor(Color.rgb(255,255,255));
                    }
                }
        );
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.linear_layout, menu);
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
