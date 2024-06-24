package com.example.contentprovider.vista;
import com.example.contentprovider.adaptador.MascotaAdaptador;
import com.example.contentprovider.pojo.Mascota;
import java.util.ArrayList;

public interface IMascotasFragmentView {
public  void generarLinearLayoutVertical();
public  MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
public void  inicializarAdaptadorMF(MascotaAdaptador adaptador);
}
