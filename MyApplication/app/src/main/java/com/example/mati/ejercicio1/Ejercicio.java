package com.example.mati.ejercicio1;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class Ejercicio extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MiDibujo(this));
    }

    class MiDibujo extends View {
        public MiDibujo(Context c){
            super(c);
        }

        protected void onDraw(Canvas lienzo){

            Paint miPincel= new Paint();
            int altura = lienzo.getHeight();
            int anchura = lienzo.getWidth();
            miPincel.setStyle(Paint.Style.FILL);

            miPincel.setColor(Color.RED);
            lienzo.drawRect(0,0,100,100,miPincel);

            miPincel.setColor(Color.BLUE);
            lienzo.drawRect(anchura-100,0,anchura,100,miPincel);

            miPincel.setColor(Color.GREEN);
            lienzo.drawRect(0,altura-100,100,altura,miPincel);

            miPincel.setColor(Color.YELLOW);
            lienzo.drawRect(anchura-100,altura-100,anchura,altura,miPincel);

            miPincel.setStyle(Paint.Style.STROKE);
            miPincel.setColor(Color.MAGENTA);
            lienzo.drawCircle(anchura/2,altura/2,(anchura/2)-100,miPincel);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ejercicio, menu);
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
