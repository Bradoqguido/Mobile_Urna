package com.example.jefer.urnatesi;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by jefersonguido on 06/09/17.
 */

public class Lista {

    //Criando objetos
    private int foto;
    private String nome, cod;
    private int voto;

    //criando default
    public Lista(int imagem, String name, String id){

        //instanciando os objetos para a função default
        this.foto = imagem;
        this.cod = name;
        this.nome = id;
    }

    //getter e setters do itens da função default
    public void setFoto(int foto) {
        this.foto = foto;
    }
    public int getFoto() {
        return foto;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCod() {
        return cod;
    }
    public void setCod(String cod) {
        this.cod = cod;
    }

    public int getVoto() {
        return voto;
    }
    public void setVoto() {
        this.voto++;
    }
}
