package com.example.jefer.urnatesi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jefersonguido on 06/09/17.
 */

public class Adaptador extends BaseAdapter{

    private LayoutInflater inflador;
    private ArrayList<Lista> listas;

    public Adaptador(Context context, ArrayList<Lista> listas){
        this.listas = listas;//faz a captura dos itens que irão preencher o listview
        inflador = LayoutInflater.from(context);//faz a captura do layout do item
    }

    @Override
    public int getCount() {
        return listas.size(); // retorna o tamanho da lista
    }

    @Override
    public Object getItem(int position) {
        return listas.get(position); // retorna a posição na lista do item
    }

    @Override
    public long getItemId(int position) {
        return position; // retorna o id do item
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        Lista item = listas.get(position); // faz a captura do item de acordo com sua posição
        view = inflador.inflate(R.layout.item_list, null); // torna o layout inflavel para podermos adicionar itens(Dados)
        ((ImageView) view.findViewById(R.id.imagem)).setImageResource(item.getFoto()); // capturando a o id da imagem
        ((TextView) view.findViewById(R.id.item)).setText((CharSequence) item.getNome()); // capturando o nome do item
        ((TextView) view.findViewById(R.id.codigo)).setText((CharSequence) item.getCod()); // capturando o código do item

        return view;
    }

}
