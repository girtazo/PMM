package com.example.mati.examendavidnavarro;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

/**
 * Created by david on 2/02/15.
 */
public class Azafata  extends  View{

    private float anchoSombrero;
    private float altoSombrero;
    private float fondoSombrero;
    private float anchoVestidoSup;
    private float anchoVestidoInf;
    private float radioCara;
    private float volumenOjos;
    private float brazos;
    private float piernas;

    public Azafata(Context c){

        super(c);

    }

    protected void onDraw(Canvas lienzo){


        Paint miPincel= new Paint();
        miPincel.setColor(Color.BLUE);
        miPincel.setStyle(Paint.Style.FILL_AND_STROKE);
        miPincel.setAntiAlias(true);

        int ancho = lienzo.getWidth();
        int alto = lienzo.getHeight();
        int xcentro = lienzo.getWidth()/2;
        xcentro = 50;
        int comienzo = 50;

        // Dibujar Sombrero
        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        path.moveTo(xcentro, comienzo);
        path.lineTo(xcentro-(anchoSombrero/2), altoSombrero + comienzo);
        //path.moveTo(xcentro-(anchoSombrero/2), altoSombrero + comienzo);
        path.lineTo(xcentro+(anchoSombrero/2), altoSombrero + comienzo);
        //path.moveTo(xcentro+(anchoSombrero/2), altoSombrero + comienzo);
        path.lineTo(xcentro, comienzo);
        path.close();

        lienzo.drawPath(path, miPincel);

        //lienzo.drawCircle(500,500,300,miPincel);

        //miPincel.setTextSize(60);
        //lienzo.drawText("MI CIRCULO",500,900,miPincel);

    }
}
