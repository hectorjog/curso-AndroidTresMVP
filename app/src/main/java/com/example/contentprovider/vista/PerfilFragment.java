package com.example.contentprovider.vista;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.contentprovider.adaptador.MascotaAdaptador;
import com.example.contentprovider.R;
import com.example.contentprovider.pojo.Mascota;

import java.util.ArrayList;


public class PerfilFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvPerfilMascota);
        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);
        listaMascotas.setLayoutManager(glm);
        //LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        //llm.setOrientation(LinearLayoutManager.VERTICAL);
        //listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();

        return v;
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        //MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Yogui",1,R.drawable.bear));
        mascotas.add(new Mascota("Yogui",2,R.drawable.bear));
        mascotas.add(new Mascota("Yogui",4,R.drawable.bear));
        mascotas.add(new Mascota("Yogui",6,R.drawable.bear));
        mascotas.add(new Mascota("Yogui",3,R.drawable.bear));
        mascotas.add(new Mascota("Yogui",4,R.drawable.bear));
        mascotas.add(new Mascota("Yogui",2,R.drawable.bear));
        mascotas.add(new Mascota("Yogui",1,R.drawable.bear));
        mascotas.add(new Mascota("Yogui",5,R.drawable.bear));
        mascotas.add(new Mascota("Yogui",1,R.drawable.bear));
        mascotas.add(new Mascota("Yogui",2,R.drawable.bear));
        mascotas.add(new Mascota("Yogui",4,R.drawable.bear));
        mascotas.add(new Mascota("Yogui",6,R.drawable.bear));
        mascotas.add(new Mascota("Yogui",3,R.drawable.bear));
        mascotas.add(new Mascota("Yogui",4,R.drawable.bear));
        mascotas.add(new Mascota("Yogui",2,R.drawable.bear));
        mascotas.add(new Mascota("Yogui",1,R.drawable.bear));
        mascotas.add(new Mascota("Yogui",5,R.drawable.bear));


    }

}
