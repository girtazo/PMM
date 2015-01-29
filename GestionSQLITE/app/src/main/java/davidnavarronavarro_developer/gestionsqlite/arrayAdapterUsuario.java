package davidnavarronavarro_developer.gestionsqlite;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by david on 29/01/15.
 */
class arrayAdapterUsuario extends ArrayAdapter {

    Activity context;
    Usuario [] datos;
    @SuppressWarnings("unchecked")

    public arrayAdapterUsuario(Activity context,Usuario [] datos) {

        super(context, R.layout.downspiner,datos);
        this.datos = datos;
        this.context=context;

    }

    public View getDropDownView(int posicion,View convertView,ViewGroup parent){
        return getView(posicion,convertView,parent);
    }

    public View getView(int posicion,View convertView,ViewGroup parent){
        View item=convertView;
        viewSpinner holder;
        if(item==null){
            LayoutInflater inflater=context.getLayoutInflater();
            item=inflater.inflate(R.layout.downspiner,null);

            holder=new viewSpinner();
            holder.login=(TextView)item.findViewById(R.id.splogin);
            holder.nombre=(TextView)item.findViewById(R.id.spnombre);
            holder.apellidos=(TextView)item.findViewById(R.id.spapellidos);


            item.setTag(holder);

        }
        else
            holder=(viewSpinner)item.getTag();

        holder.login.setText(datos[posicion].getLogin());
        holder.nombre.setText(datos[posicion].getNombre());
        holder.apellidos.setText(datos[posicion].getApellidos());

        return item;
    }

}
