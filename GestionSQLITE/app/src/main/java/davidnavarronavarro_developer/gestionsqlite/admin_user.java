package davidnavarronavarro_developer.gestionsqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Spinner;


public class admin_user extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_user);

        Usuario [] usuarios;

        DB database = new DB(this, "gestor", null, 1);

        SQLiteDatabase conexion = database.getWritableDatabase();
        // Comprobar conexion
        if (conexion!=null) {

            String[] campos = new String []{ "login","password","nombre","apellidos","telefono" };

            Cursor cursor = conexion.query("usuario",campos,null,null,null,null,null);
            usuarios = new Usuario[cursor.getCount()];
            int c = 0;
            if(cursor.moveToFirst()){

                do{

                    usuarios [c] = new Usuario(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getInt(4));
                    c++;
                } while (cursor.moveToNext());
            }
            conexion.close();

            final Spinner spi = (Spinner) findViewById(R.id.usuarios);
            arrayAdapterUsuario adap= new arrayAdapterUsuario(this,usuarios);
            spi.setAdapter(adap);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.admin_user, menu);
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
