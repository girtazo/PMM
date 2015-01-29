package com.example.mati.examendavidnavarro;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by mati on 29/01/15.
 */
public class AdapterZona extends ArrayAdapter {

    Activity context;
    Destino[] datos;

    //@SuppressWarnings("unchecked")

    public AdapterZona(Activity context, Destino[] datos) {

        super(context, R.layout.zonaspinner, datos);
        this.datos = datos;
        this.context = context;

    }

    public View getDropDownView(int posicion, View convertView, ViewGroup parent) {
        return getView(posicion, convertView, parent);
    }

    public View getView(int posicion, View convertView, ViewGroup parent) {
        View item = convertView;
        viewSpinner holder;
        if (item == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            item = inflater.inflate(R.layout.zonaspinner, null);

            holder = new viewSpinner();
            holder.zona = (TextView) item.findViewById(R.id.spzona);
            holder.continente = (TextView) item.findViewById(R.id.spcontinente);
            holder.precio = (TextView) item.findViewById(R.id.spprecio);


            item.setTag(holder);

        } else
            holder = (viewSpinner) item.getTag();

        holder.zona.setText(datos[posicion].getZona());
        holder.continente.setText(datos[posicion].getContinente());
        holder.precio.setText(datos[posicion].getPrecio().toString());

        return item;
    }
}
