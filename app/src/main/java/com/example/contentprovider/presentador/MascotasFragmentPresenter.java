package com.example.contentprovider.presentador;
import android.content.Context;
import com.example.contentprovider.database.MascotasConstructor;
import  com.example.contentprovider.pojo.Mascota;
import  com.example.contentprovider.vista.IMascotasFragmentView;
import java.util.ArrayList;
public class MascotasFragmentPresenter implements IMascotasFragmentPresenter {

    private IMascotasFragmentView iMascotasFragmentView;
    private Context context;
    private MascotasConstructor constructorMascotas;
    private ArrayList<Mascota> mascotas;
    private String filtro;

    public MascotasFragmentPresenter(IMascotasFragmentView iMascotasFragmentView, Context context, String filtro){
        this.iMascotasFragmentView = iMascotasFragmentView;
        this.context = context;
        this.filtro = filtro;
        obtenerMascotasBaseDatos(filtro);
    }

    @Override
    public void obtenerMascotasBaseDatos(String filtro) {
        constructorMascotas = new MascotasConstructor(context);
        mascotas = constructorMascotas.obtenerMascotas(filtro);
        mostrarMascotasMF();
    }

    @Override
    public void mostrarMascotasMF() {
        iMascotasFragmentView.inicializarAdaptadorMF(iMascotasFragmentView.crearAdaptador(mascotas));
        iMascotasFragmentView.generarLinearLayoutVertical();
    }

}
