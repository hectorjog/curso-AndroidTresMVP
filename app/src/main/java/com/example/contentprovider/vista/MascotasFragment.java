package com.example.contentprovider.vista;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.contentprovider.database.DatabsesConstants;
import com.example.contentprovider.R;
import com.example.contentprovider.pojo.Mascota;
import com.example.contentprovider.adaptador.MascotaAdaptador;

import com.example.contentprovider.presentador.IMascotasFragmentPresenter;

import com.example.contentprovider.presentador.MascotasFragmentPresenter;



import java.util.ArrayList;

public class MascotasFragment extends Fragment implements IMascotasFragmentView {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IMascotasFragmentPresenter presenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_mascotas, container, false);


        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        presenter= new MascotasFragmentPresenter(this,getContext(), DatabsesConstants.MASCOTAS_ALL);

        /*
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
        */

        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorMF(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }


    /*
    public void inicializarAdaptador(){
        com.example.contentprovider.adaptador.MascotaAdaptador adaptador = new com.example.contentprovider.adaptador.MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Oveha",2,R.drawable.sheep));
        mascotas.add(new Mascota("Yogui",4,R.drawable.bear));
        mascotas.add(new Mascota("King Kong",5,R.drawable.monkey));


    }
    */

}
