package com.pruebas123.petagram.presentador;

import android.content.Context;

import com.pruebas123.petagram.db.ConstructorMascotas;
import com.pruebas123.petagram.fragmnet.IRecyclerviewFragmentView;
import com.pruebas123.petagram.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerviewFragmentPresenter implements IRecyclerviewFragmentPresenter {

    private IRecyclerviewFragmentView iRecyclerviewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerviewFragmentPresenter(IRecyclerviewFragmentView iRecyclerviewFragmentView, Context context) {
        this.iRecyclerviewFragmentView = iRecyclerviewFragmentView;
        this.context = context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerviewFragmentView.inicializarAdaptadorRV(iRecyclerviewFragmentView.crearAdaptador(mascotas));
        iRecyclerviewFragmentView.generarLinerLaoutVertical();
    }
}
