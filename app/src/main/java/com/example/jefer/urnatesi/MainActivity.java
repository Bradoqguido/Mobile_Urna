package com.example.jefer.urnatesi;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.jefer.urnatesi.R.mipmap.ic_launcher;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static String IDBUSCA = "IDBUSCA", ARRAY = "ARRAY", A1984 = "A1984", CRIMEECASTIGO = "CRIMEECASTIGO", DONQUIXOTE = "DONQUIXOTE", METAMORFOSE = "METAMORFOSE";

    private View itemSelecionado;
    private Lista livroSelecionado;

    // cria objetos
    private ListView listView;
    private Adaptador adaptador;
    private ArrayList<Lista> lista;
    private Button buscar, branco, corrige, confirma;
    private EditText itembusca;
    private int vBranco, vNulo;
    private ImageView imageView;


    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // inicializa o som
        mp = MediaPlayer.create(this, R.raw.somurna);

        // inicia os objetos
        listView = (ListView) findViewById(R.id.lista);

        imageView = (ImageView) findViewById(R.id.imageView);

        buscar = (Button) findViewById(R.id.buscar);
        buscar.setOnClickListener(this);

        branco = (Button) findViewById(R.id.branco);
        branco.setOnClickListener(this);

        confirma = (Button) findViewById(R.id.confirma);
        confirma.setOnClickListener(this);

        corrige = (Button) findViewById(R.id.corrige);
        corrige.setOnClickListener(this);

        itembusca = (EditText) findViewById(R.id.itembusca);

        // Criando lista que preenchera o ListView
        lista = new ArrayList<Lista>();
        Lista item1 = new Lista(R.drawable.abcd, "1", "1984");
        Lista item2 = new Lista(R.drawable.crimeecastigo, "2", "Crime e Castigo");
        Lista item3 = new Lista(R.drawable.donquixote, "3", "Don Quixote");
        Lista item4 = new Lista(R.drawable.metamorfose, "4", "Metamorfose");

        // adiciona os itens na lista
        lista.add(item1);
        lista.add(item2);
        lista.add(item3);
        lista.add(item4);

        // Inicializa o adaptador e adiciona os itens
        adaptador = new Adaptador(this, lista);

        // Adapta os itens a lista
        listView.setAdapter(adaptador);


        // faz a exibição e captura dos itens selecionados
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id) {

                Lista item = (Lista) adaptador.getItem(posicao); // Pega o item que foi selecionado

                if(itemSelecionado != null) {
                    itemSelecionado.setBackgroundColor(Color.WHITE); // define o fundo do item selecionado como branco
                }

                itemSelecionado = view;
                itemSelecionado.setBackgroundColor(Color.LTGRAY); // define o fundo do item selecionado como cinza claro
                imageView.setImageResource(lista.get(posicao).getFoto());
                livroSelecionado = item;
            }
        });

    }

    @Override
    public void onClick(View view) {

        Intent finaliza = new Intent(getApplicationContext(), Finaliza.class); // Cria o objeto que ira chamar a tela final caso o usuario clique em confirmar

        if ((view.getId() == R.id.branco) && (itemSelecionado == null)) {
            vBranco++;
            mp.start();
            itembusca.setText("");
            startActivity(finaliza);

        }

        if(itemSelecionado == null && itembusca == null){

            Toast.makeText(getApplicationContext(), "  Não é possivel Executar essa ação\nSelecione um Livro ou Faça uma Busca",Toast.LENGTH_LONG).show();
        }
        else {
            switch (view.getId()) {
                case R.id.buscar:
                    String busca = itembusca.getText().toString();

                    int b = 0;
                    b = Integer.parseInt(busca);

                    if (b > 4 && b != 254) {
                        Toast.makeText(getApplicationContext(), "   O Código não Existe \nVoce está votando Nulo", Toast.LENGTH_LONG).show();
                        vNulo++; // vota no item selecionado
                        mp.start(); // inicia o som
                        itembusca.setText("");
                        if(itemSelecionado != null){
                            imageView.setImageResource(R.mipmap.ic_launcher);
                            itemSelecionado.setBackgroundColor(Color.WHITE); // define o fundo do item selecionado como branco
                            itemSelecionado = null; // define a view como nula
                        }
                        startActivity(finaliza);

                    } else {
                        Intent resbusca = new Intent(getApplicationContext(), Resultadobusca.class);
                        resbusca.putExtra("IDBUSCA", b);
                        GetItemBusca.GetInstance().setTest(lista); // manda a lista completa para outra classe
                        itembusca.setText("");
                        startActivity(resbusca);
                    }

                    //inicia a Intent que faz a apuração dos votos
                    if (b == 254) {
                        Intent apuracao = new Intent(getApplicationContext(), Apuracao.class);
                        apuracao.putExtra("A1984", lista.get(0).getVoto());
                        apuracao.putExtra("CRIMEECASTIGO", lista.get(1).getVoto());
                        apuracao.putExtra("DONQUIXOTE", lista.get(2).getVoto());
                        apuracao.putExtra("METAMORFOSE", lista.get(3).getVoto());
                        apuracao.putExtra("BRANCO", vBranco);
                        apuracao.putExtra("NULO", vNulo);
                        startActivity(apuracao);
                        itembusca.setText("");
                    }
                    break;

                case R.id.corrige:
                    if(itemSelecionado != null){
                        itemSelecionado.setBackgroundColor(Color.WHITE); // define o fundo do item selecionado como branco
                        itemSelecionado = null; // define a view como nula
                        Toast.makeText(getApplicationContext(), "  Não é possivel Executar essa ação\nSelecione um Livro ou Faça uma Busca",Toast.LENGTH_LONG).show();
                    }
                    imageView.setImageResource(R.mipmap.ic_launcher);
                    itembusca.setText("");
                    break;

                case R.id.confirma:
                    if(itemSelecionado != null){
                        for (int i = 0; i <= 4; i++) {
                            if (i != Integer.parseInt(livroSelecionado.getCod())) {
                                livroSelecionado.setVoto(); // vota no item selecionado
                                mp.start(); // inicia o som
                                itembusca.setText("");
                                imageView.setImageResource(R.mipmap.ic_launcher);
                                itemSelecionado.setBackgroundColor(Color.WHITE); // define o fundo do item selecionado como branco
                                itemSelecionado = null; // define a view como nula
                                startActivity(finaliza);
                                break;
                            }
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "  Não é possivel Executar essa ação\nSelecione um Livro ou Faça uma Busca",Toast.LENGTH_LONG).show();
                        itemSelecionado = null; // define a view como nula
                    }
            }
        }
    }


}
