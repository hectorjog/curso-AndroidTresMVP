package com.example.contentprovider.vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


import com.example.contentprovider.About;
import com.example.contentprovider.Contacto;
import com.example.contentprovider.adaptador.MascotaAdaptador;
import com.example.contentprovider.database.DatabsesConstants;

import com.example.contentprovider.R;
import com.example.contentprovider.pojo.Mascota;
import com.example.contentprovider.presentador.IMascotasFragmentPresenter;
import  com.example.contentprovider.presentador.MascotasFragmentPresenter;


import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity implements IMascotasFragmentView {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IMascotasFragmentPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favoritas_mascotas);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBarFavoritos);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotasFavoritas);
        presenter = new MascotasFragmentPresenter(this, this, DatabsesConstants.MASCOTAS_TOP5);

        /*







    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Oveha",6,R.drawable.sheep));
        mascotas.add(new Mascota("King Kong",5,R.drawable.monkey));
        mascotas.add(new Mascota("Yogui",4,R.drawable.bear));

    }

    */
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.contacto:
                intent = new Intent(this, Contacto.class);
                startActivity(intent);
                break;

            case R.id.about:
                intent = new Intent(this, About.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
@Override
public  void generarLinearLayoutVertical(){
    LinearLayoutManager llm = new LinearLayoutManager(this);
    llm.setOrientation(LinearLayoutManager.VERTICAL);

    listaMascotas.setLayoutManager(llm);

}

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        return adaptador;
    }
    @Override
    public void inicializarAdaptadorMF(MascotaAdaptador adaptador) {
        //MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }
}
