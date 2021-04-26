package br.com.local.listaplanetaapp2h;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Declarar a variável que irá receber a ListView do XML
    ListView listView;
    //Criar os arrays que serão inseridos na listView

    String nomePlanetas[] = {"Jupiter", "Lua", "Marte", "Mercurio",
            "Netuno", "Plutão", "Saturno", "Sol", "Terra", "Urano", "Venus"};

    int imgPlanetas[] = {R.drawable.jupiter, R.drawable.lua,
            R.drawable.marte, R.drawable.mercurio, R.drawable.netuno,
            R.drawable.plutao, R.drawable.saturno, R.drawable.sol,
            R.drawable.terra, R.drawable.urano, R.drawable.venus};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //a variavel listview está recebendo a listView XML
        listView = findViewById(R.id.listaPlanetas);

        //Criar o objeto/classe que irá inserir o modelo na listView

        CustomAdapter customAdapter = new CustomAdapter();

        //Carregar o baseAdapter na listView
        listView.setAdapter(customAdapter);

        //Criando evento de click na listView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), VisualizaPlaneta_MainActivity.class);
                //Passando valores de uma janela para outra
                intent.putExtra("nomePlaneta", nomePlanetas[i]);
                intent.putExtra("imagemPlaneta", imgPlanetas[i]);

                startActivity(intent);

            }
        });


    }

    //inner class - Classe dentro de outra Classe
    public class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return imgPlanetas.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        //Montar o modelo para ser inserido na lista de planetas - ListView
        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            TextView txtNomePlaneta;
            ImageView imagemPlaneta;

            //instanciando o modelo com os componentes para inserir na Lista
            View carregaView = getLayoutInflater().inflate(R.layout.modelo_lista_planetas, null);

            txtNomePlaneta = carregaView.findViewById(R.id.txtListaPlaneta);
            imagemPlaneta = carregaView.findViewById(R.id.imgListaPlaneta);

            //Carregando os valores nos componentes

            txtNomePlaneta.setText(nomePlanetas[position]);
            imagemPlaneta.setImageResource(imgPlanetas[position]);

            return carregaView;
        }
    }
}