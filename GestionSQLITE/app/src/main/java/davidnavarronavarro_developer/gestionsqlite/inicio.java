package davidnavarronavarro_developer.gestionsqlite;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class inicio extends ActionBarActivity {

    private DB database;
    public void showToast(String text){
        Toast.makeText(this,text,Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        final Button btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
        final Button btnInicio = (Button) findViewById(R.id.btnInicio);

        database = new DB(this, "gestor", null, 1);

        SQLiteDatabase conexion = database.getWritableDatabase();

        // Obtenemos conexion
        conexion.execSQL("INSERT INTO usuario ( login, password, nombre, apellidos, telefono) VALUES ( 'david', 'g2dsg15', 'david','navarro',9552155)");

        conexion.close();

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent MostrarDatos = new Intent(inicio.this,registrar.class);
                Bundle datos = new Bundle();

                MostrarDatos.putExtras(datos);
                startActivity(MostrarDatos);
            }
        });

        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText usuario = (EditText)findViewById(R.id.incusuario);
                EditText password = (EditText)findViewById(R.id.incpassword);

                SQLiteDatabase conexion = database.getWritableDatabase();
                // Comprobar conexion
                if (conexion!=null) {

                    String[] campos = new String []{ "login","password" };
                    String[] busqueda = new String[]{ usuario.getText().toString() };

                    Cursor cursor = conexion.query("usuario",campos,"login=?",busqueda,null,null,null);

                    if(cursor.moveToFirst()){

                        do{

                            showToast(cursor.getString(0));
                            showToast(cursor.getString(1));
                        } while (cursor.moveToNext());
                    }
                    conexion.close();
                }
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.inicio, menu);
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
