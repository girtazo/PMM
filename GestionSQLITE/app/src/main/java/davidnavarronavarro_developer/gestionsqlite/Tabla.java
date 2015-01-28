package davidnavarronavarro_developer.gestionsqlite;

/**
 * Created by david on 28/01/15.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

import java.util.ArrayList;
import java.util.Hashtable;

public class Tabla {

    private SQLiteDatabase conexion;
    private DB db;
    private ArrayList<Campo> campos;
    private ArrayList<Hashtable> valores;
    public String nombre;
    private int nCampos;

    public Tabla(Context context,String database,String nombre, CursorFactory almacen , int version){

        this.db = new DB(context, database, almacen,version);
        this.nombre = nombre;
        this.campos = new ArrayList<Campo>();
        this.conexion = db.getWritableDatabase();


        /*Lector = ((Statement)conexion.createStatement()).executeQuery("Select * FROM "+nombre+" LIMIT 1");

        this.nCampos = Lector.getMetaData().getColumnCount();

        for (int campo=1; campo <= nCampos; campo++) {

            campos.add(new Campo (
                            Lector.getMetaData().getColumnLabel(campo),
                            Lector.getType()
                    )
            );

        }

        Lector.close();*/

    }

    /*public Cursor<Hashtable> listar() {

        valores = new ArrayList<Hashtable>();

        //Lector = ((Statement)conexion.createStatement()).executeQuery("Select * FROM "+nombre);

        while (Lector.next()) {

            Hashtable<String, Object> tupla = new Hashtable<String, Object>();

            for(int campo = 1;campo <= nCampos;campo++){

                tupla.put(
                        campos.get(campo-1).nombre,
                        Lector.getObject(campo)
                );
            }

            valores.add(tupla);
        }

        Lector.close();

        return this.valores;
    }

    public void insertar(Hashtable<String,Object> tupla) throws SQLException{

        String sentencia = "INSERT INTO " + nombre + " (";

        int nCampo = 0;

        Enumeration<String> campo = tupla.keys();

        while(campo.hasMoreElements()){

            if( tupla.size() > nCampo+1 ){

                sentencia += campo.nextElement()+", ";

            } else {

                sentencia += campo.nextElement()+") ";

            }
            nCampo++;
        }


        sentencia += "VALUES (";


        for(int valor = 0; valor < tupla.size(); valor++){

            if( tupla.size() > valor+1 ){

                sentencia += "?, ";

            } else {

                sentencia += "?) ";

            }
        }

        sentenciaSQL = conexion.prepareStatement(sentencia);

        Object[] valor = tupla.values().toArray();

        for ( nCampo = 0; nCampo < tupla.size(); nCampo++) {

            sentenciaSQL.setObject(nCampo+1, valor[nCampo]);

        }

        sentenciaSQL.executeUpdate();
        sentenciaSQL.close();
    }

    public void modificar(Hashtable<String,Object> tupla,Hashtable<String,Object> select) throws SQLException{

        String sentencia = "UPDATE " + nombre + " SET ";

        int nCampo = 0;

        Enumeration<String> campos = tupla.keys();

        while(campos.hasMoreElements()){

            if( tupla.size() > nCampo+1 ){

                sentencia += campos.nextElement()+"=?, ";

            } else {

                sentencia += campos.nextElement()+"=? ";

            }
            nCampo++;
        }


        sentencia += "WHERE ";

        Object[] valor = select.values().toArray();
        nCampo = 0;

        campos = select.keys();

        while(campos.hasMoreElements()){

            if( tupla.size() > nCampo+1 ){

                sentencia += campos.nextElement()+"=?, ";

            } else {

                sentencia += campos.nextElement()+"=? ";

            }
            nCampo++;
        }

        sentenciaSQL = conexion.prepareStatement(sentencia);

        valor = tupla.values().toArray();

        for ( nCampo = 0; nCampo < tupla.size(); nCampo++) {

            sentenciaSQL.setObject(nCampo+1, valor[nCampo]);

        }

        valor = select.values().toArray();

        for ( nCampo = nCampo; nCampo < select.size()+tupla.size(); nCampo++) {

            sentenciaSQL.setObject(nCampo+1, valor[nCampo-tupla.size()]);

        }

        sentenciaSQL.executeUpdate();
        sentenciaSQL.close();
    }

    public void borrar(Hashtable<String,Object> tupla) throws SQLException{

        String sentencia = "DELETE FROM " + nombre + " WHERE ";

        int nCampo = 0;

        Enumeration<String> campos = tupla.keys();
        Object[] valor = tupla.values().toArray();

        while(campos.hasMoreElements()){

            if( tupla.size() > nCampo+1 ){

                sentencia += campos.nextElement()+"=?, ";

            } else {

                sentencia += campos.nextElement()+"=? ";

            }
        }


        sentenciaSQL = conexion.prepareStatement(sentencia);

        valor = tupla.values().toArray();

        for ( nCampo = 0; nCampo < tupla.size(); nCampo++) {

            sentenciaSQL.setObject(nCampo+1, valor[nCampo]);

        }

        sentenciaSQL.executeUpdate();
        sentenciaSQL.close();

    }
}*/

}
