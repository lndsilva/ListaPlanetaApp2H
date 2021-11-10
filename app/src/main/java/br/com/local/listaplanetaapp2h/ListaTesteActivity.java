package br.com.local.listaplanetaapp2h;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class ListaTesteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_teste_layout);


        //instancia da classe / objeto
        Planetas planetas =  new Planetas();



        planetas.setNomePlanetas("Jupiter");
        planetas.setImgPlanetas(R.drawable.jupiter);

        Planetas p1 = new Planetas("Terra",R.drawable.terra);

         int imagem = p1.getImgPlanetas();
        String nome =  p1.getNomePlanetas();





    }


}