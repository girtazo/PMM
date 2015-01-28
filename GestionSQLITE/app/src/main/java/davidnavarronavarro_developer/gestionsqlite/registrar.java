package davidnavarronavarro_developer.gestionsqlite;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class registrar extends ActionBarActivity {

    private DB database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        database= new DB(this, "gestor", null, 1);

        final Button btnRegistrar = (Button)findViewById(R.id.btnRegistrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            EditText login = (EditText)findViewById(R.id.login);
            EditText password = (EditText)findViewById(R.id.password);
            EditText nombre = (EditText)findViewById(R.id.nombre);
            EditText apellidos = (EditText)findViewById(R.id.apellidos);
            EditText telefono = (EditText)findViewById(R.id.telefono);

            Usuario OUsuario = new Usuario(
                    login.getText().toString(),
                    password.getText().toString(),
                    nombre.getText().toString(),
                    apellidos.getText().toString(),
                    Integer.parseInt(telefono.getText().toString()));



            // Obtenemos conexion
            SQLiteDatabase conexion = database.getWritableDatabase();

            // Comprobar conexion
            if (conexion!=null) {

                    // Creamos los datos
                    ContentValues usuario = new ContentValues();
                    usuario.put("login",OUsuario.getLogin());
                    usuario.put("password",OUsuario.getPassword());
                    usuario.put("nombre",OUsuario.getNombre());
                    usuario.put("apellidos",OUsuario.getApellidos());
                    usuario.put("telefono",OUsuario.getTelefono());

                    //Introducimos los datos en la tabla Clientes
                    conexion.insert("usuario", null, usuario);

            }
            Intent MostrarDatos = new Intent(registrar.this,inicio.class);
            Bundle datos = new Bundle();

            MostrarDatos.putExtras(datos);
            startActivity(MostrarDatos);
        }});






    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.registrar, menu);
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
