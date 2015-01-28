package com.example.david.spinnerpesona;

/**
 * Created by david on 12/11/14.
 */

import java.io.Serializable;

public class Persona implements Serializable{
<<<<<<< HEAD
    public String nombre;
    public String apellidos;
    public int edad;
=======
    private String nombre;
    private String apellidos;
    private int edad;
>>>>>>> 98ab39947c27975de8435f2ca1ac9183b780fda5
    Persona(String nombre,String apellidos,int edad){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }
<<<<<<< HEAD
=======
    public String getNombre(){
        return this.nombre;
    }
    public String getApellidos(){
        return this.apellidos;
    }
    public int getEdad(){
        return this.edad;
    }
>>>>>>> 98ab39947c27975de8435f2ca1ac9183b780fda5
}
