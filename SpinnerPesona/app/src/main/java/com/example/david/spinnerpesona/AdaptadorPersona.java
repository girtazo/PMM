package com.example.david.spinnerpesona;

import android.app.Activity;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 15/11/14.
 */
public class AdaptadorPersona extends ArrayAdapter<Persona> {
    public Activity activity;
    private List<Persona> personas;

    public AdaptadorPersona(Activity activity,int layout,List<Persona> personas){
        super(activity,layout,personas);
        this.activity = activity;
        this.personas = personas;

    }
    public View getDropDownView(int posicion,View convertView,ViewGroup Parent){
        View vistaDesplegada = getView(posicion,convertView,Parent);
        return vistaDesplegada;
    }
    public View getView(int posicion,View convertView,ViewGroup Parent){

        LayoutInflater inflater = activity.getLayoutInflater();
        View item = inflater.inflate(R.layout.lista,null);

        TextView textViewNombre = (TextView) item.findViewById(R.id.persona);

        textViewNombre.setText(personas.get(posicion).getNombre());

        return item;
    }
}
