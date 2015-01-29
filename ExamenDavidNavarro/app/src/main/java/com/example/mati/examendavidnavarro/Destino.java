package com.example.mati.examendavidnavarro;

/**
 * Created by mati on 29/01/15.
 */
public class Destino {

    private String zona;
    private String continente;
    private Integer precio;

    public Destino(String zona, String continente,Integer precio){

        this.zona = zona;
        this.continente = continente;
        this.precio = precio;
    }

    public String getZona(){

        return zona;
    }

    public String getContinente(){

        return continente;
    }

    public Integer getPrecio(){

        return precio;
    }
}
