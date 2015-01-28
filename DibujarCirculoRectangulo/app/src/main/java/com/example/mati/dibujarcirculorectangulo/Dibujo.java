package com.example.mati.dibujarcirculorectangulo;

/*import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;

/**
 * Created by david on 2/12/14.
 */
/*public class Dibujo extends View{
    //private Object figura;
    public Dibujo(Context context/*, Object figura*//*){
   /*     super(context);
        //this.figura = figura;
    }
    public Dibujo(Context context, AttributeSet atributos)
    {
        super(context, atributos);
    }

    @Override
    protected void onDraw(Canvas canvas){
        Paint pincel = new Paint();
        pincel.setStrokeWidth(5);
        pincel.setStyle(Paint.Style.FILL_AND_STROKE);
        pincel.setColor(Color.BLACK);
        /*if(Rectangulo.class.isInstance(figura)){
            Rectangulo rectangulo = (Rectangulo) figura;
            canvas.drawRect(20,20,20+rectangulo.getAncho(),20+rectangulo.getAlto(),pincel);
        }else {
            Circulo circulo = (Circulo) figura;*/
        /*    canvas.drawCircle(, 20,20 , pincel);
/*
        //}

    }
}*/
import android.content.Context;
        import android.graphics.Canvas;
        import android.graphics.Color;
        import android.graphics.Paint;
        import android.util.AttributeSet;
        import android.view.View;
        import android.widget.EditText;

/**
 * Created by david on 2/12/14.
 */
public class Dibujo extends View{


    public Dibujo(Context context){
        super(context);
    }
    public Dibujo(Context context, AttributeSet atributos)
    {
        super(context, atributos);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        Paint pincel = new Paint();
        pincel.setStrokeWidth(5);
        pincel.setStyle(Paint.Style.FILL_AND_STROKE);
        pincel.setColor(Color.BLACK);
        int viewAncho=getWidth();
        int viewAlto=getHeight();
        canvas.drawRect(2,2,viewAncho-2,2+2,pincel);

        canvas.drawCircle(viewAncho/2,viewAlto/2, 20 , pincel);

    }
}

