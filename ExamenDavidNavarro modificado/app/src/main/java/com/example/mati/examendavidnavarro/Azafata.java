package com.example.mati.examendavidnavarro;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.view.View;


/**
 * Created by david on 2/02/15.
 */
public class Azafata  extends  View{

    private int anchoSombrero;
    private int altoSombrero;
    private int fondoSombrero;
    private int anchoVestidoSup;
    private int altoVestido;
    private int anchoVestidoInf;
    private int radioCara;
    private int volumenOjos;
    private int brazos;
    private int piernas;
    private int espacioPiernas;

    public Azafata(Context c){

        super(c);
        this.anchoSombrero = 200;
        this.altoSombrero = 200;
        this.fondoSombrero = 40;
        this.radioCara = 80;
        this.anchoVestidoSup = 90;
        this.anchoVestidoInf = 200;
        this.altoVestido = 300;
        this.piernas = 150;
        this.espacioPiernas = 12;
        this.volumenOjos = 5;
    }
    public void poligono (Point [] vertices, Paint paint,Canvas canvas){

        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        path.moveTo(vertices[0].x, vertices[0].y);
        for(int c = 1;c < vertices.length; c++ ){

            path.lineTo(vertices[c].x, vertices[c].y);
        }
        path.lineTo(vertices[0].x, vertices[0].y);
        path.close();

        canvas.drawPath(path, paint);
    }

    protected void onDraw(Canvas lienzo){


        Paint miPincel= new Paint();


        int ancho = lienzo.getWidth();
        int alto = lienzo.getHeight();
        int xcentro = lienzo.getWidth()/2;
        int comienzo = 50;

        // Dibujar Cabeza

        miPincel.setColor(Color.BLUE);
        miPincel.setStrokeWidth(50);
        miPincel.setStyle(Paint.Style.FILL);

        lienzo.drawCircle(xcentro,radioCara + altoSombrero - fondoSombrero + comienzo,radioCara,miPincel);

        miPincel.setColor(Color.BLACK);
        miPincel.setStrokeWidth(5);
        miPincel.setStyle(Paint.Style.STROKE);

        lienzo.drawCircle(xcentro,radioCara + altoSombrero - fondoSombrero + comienzo,radioCara,miPincel);

        // Dibujar Sombrero
        Point [] vertices = new Point[3];

        vertices[0] = new Point(xcentro, comienzo);
        vertices[1] = new Point(xcentro-(anchoSombrero/2), altoSombrero + comienzo);
        vertices[2] = new Point(xcentro+(anchoSombrero/2), altoSombrero + comienzo);

        miPincel.setColor(Color.BLUE);
        miPincel.setStrokeWidth(50);
        miPincel.setStrokeJoin(Paint.Join.ROUND);
        miPincel.setStrokeCap(Paint.Cap.ROUND);
        miPincel.setStyle(Paint.Style.FILL);

        poligono(vertices,miPincel,lienzo);

        miPincel.setColor(Color.BLACK);
        miPincel.ascent();
        miPincel.setStrokeWidth(5);
        miPincel.setStyle(Paint.Style.STROKE);

        poligono(vertices,miPincel,lienzo);

        // Brazos
        vertices = new Point[2];

        vertices[0] = new Point( xcentro - ( anchoVestidoSup / 2 ), comienzo + altoSombrero - fondoSombrero + ( radioCara * 2 ) +50);
        vertices[1] = new Point( xcentro - ( anchoVestidoSup / 2 )-100, comienzo + altoSombrero - fondoSombrero + ( radioCara * 2 ) +150);

        miPincel.setColor(Color.BLUE);
        miPincel.setStrokeWidth(50);
        miPincel.setStyle(Paint.Style.FILL);

        poligono(vertices,miPincel,lienzo);

        miPincel.setColor(Color.BLACK);
        miPincel.setStrokeWidth(5);
        miPincel.setStyle(Paint.Style.STROKE);

        poligono(vertices,miPincel,lienzo);

        vertices[0] = new Point( xcentro + ( anchoVestidoSup / 2 ), comienzo + altoSombrero - fondoSombrero + ( radioCara * 2 ) +50);
        vertices[1] = new Point( xcentro + ( anchoVestidoSup / 2 )+100, comienzo + altoSombrero - fondoSombrero + ( radioCara * 2 ) +150);

        miPincel.setColor(Color.BLUE);
        miPincel.setStrokeWidth(50);
        miPincel.setStyle(Paint.Style.FILL);

        poligono(vertices,miPincel,lienzo);

        miPincel.setColor(Color.BLACK);
        miPincel.setStrokeWidth(5);
        miPincel.setStyle(Paint.Style.STROKE);

        poligono(vertices,miPincel,lienzo);

        // Piernas
        vertices[0] = new Point( xcentro - espacioPiernas, comienzo + altoSombrero - fondoSombrero + ( radioCara * 2 ) + altoVestido );
        vertices[1] = new Point( xcentro - espacioPiernas, comienzo + altoSombrero - fondoSombrero + ( radioCara * 2 ) + altoVestido + piernas );

        miPincel.setColor(Color.BLUE);
        miPincel.setStrokeWidth(50);
        miPincel.setStyle(Paint.Style.FILL);

        poligono(vertices,miPincel,lienzo);

        miPincel.setColor(Color.BLACK);
        miPincel.setStrokeWidth(5);
        miPincel.setStyle(Paint.Style.STROKE);

        poligono(vertices,miPincel,lienzo);

        vertices[0] = new Point( xcentro + espacioPiernas, comienzo + altoSombrero - fondoSombrero + ( radioCara * 2 ) + altoVestido );
        vertices[1] = new Point( xcentro + espacioPiernas, comienzo + altoSombrero - fondoSombrero + ( radioCara * 2 ) + altoVestido + piernas );

        miPincel.setColor(Color.BLUE);
        miPincel.setStrokeWidth(50);
        miPincel.setStyle(Paint.Style.FILL);

        poligono(vertices,miPincel,lienzo);

        miPincel.setColor(Color.BLACK);
        miPincel.setStrokeWidth(5);
        miPincel.setStyle(Paint.Style.STROKE);

        poligono(vertices,miPincel,lienzo);

        // Vestido
        vertices = new Point[4];

        vertices[0] = new Point( xcentro - ( anchoVestidoSup / 2 ), comienzo + altoSombrero - fondoSombrero + ( radioCara * 2 ) );
        vertices[1] = new Point( xcentro + ( anchoVestidoSup / 2 ), comienzo + altoSombrero - fondoSombrero + ( radioCara * 2 ) );
        vertices[2] = new Point( xcentro + ( anchoVestidoInf / 2 ), comienzo + altoSombrero - fondoSombrero + ( radioCara * 2 ) + altoVestido );
        vertices[3] = new Point(xcentro - ( anchoVestidoInf / 2 ), comienzo + altoSombrero - fondoSombrero + ( radioCara * 2 ) + altoVestido );

        miPincel.setColor(Color.BLUE);
        miPincel.setStrokeWidth(50);
        miPincel.ascent();
        miPincel.setStyle(Paint.Style.FILL);

        poligono(vertices,miPincel,lienzo);

        miPincel.setColor(Color.BLACK);
        miPincel.setStrokeWidth(5);
        miPincel.ascent();
        miPincel.setStyle(Paint.Style.STROKE);

        poligono(vertices,miPincel,lienzo);

        // Ojos

        miPincel.setColor(Color.WHITE);
        miPincel.setStrokeWidth(50);
        miPincel.setStyle(Paint.Style.FILL);

        lienzo.drawCircle(xcentro - (radioCara/3),radioCara + altoSombrero - fondoSombrero + comienzo,volumenOjos,miPincel);

        miPincel.setColor(Color.BLACK);
        miPincel.setStrokeWidth(2);
        miPincel.setStyle(Paint.Style.STROKE);

        lienzo.drawCircle(xcentro - (radioCara/3),radioCara + altoSombrero - fondoSombrero + comienzo,volumenOjos,miPincel);

        miPincel.setColor(Color.WHITE);
        miPincel.setStrokeWidth(50);
        miPincel.setStyle(Paint.Style.FILL);

        lienzo.drawCircle(xcentro + (radioCara/3),radioCara + altoSombrero - fondoSombrero + comienzo,volumenOjos,miPincel);

        miPincel.setColor(Color.BLACK);
        miPincel.setStrokeWidth(2);
        miPincel.setStyle(Paint.Style.STROKE);

        lienzo.drawCircle(xcentro + (radioCara/3),radioCara + altoSombrero - fondoSombrero + comienzo,volumenOjos,miPincel);


        //Boca
        miPincel.setStrokeWidth(4);

        int centerHeight = radioCara + altoSombrero - fondoSombrero + comienzo-30;
        float circleDistance = 110;

        Path arrowPath = new Path();

        RectF arrowOval = new RectF();
        arrowOval.set(xcentro-130,
                centerHeight-80,
                xcentro + circleDistance,
                centerHeight+80);

        //add the oval to path
        arrowPath.addArc(arrowOval,110,-50);

        //draw path on canvas
        lienzo.drawPath(arrowPath, miPincel);

    }
}
