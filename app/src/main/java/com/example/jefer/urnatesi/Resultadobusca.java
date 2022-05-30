package com.example.jefer.urnatesi;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class Resultadobusca extends AppCompatActivity implements View.OnClickListener{

    private Button corrige, confirma;
    private ImageView imageView;
    private int abcd = 0, crimeecastigo = 0, donquixote = 0, metamorfose = 0;
    int recebe = 0;
    private Lista test;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultadobusca);

        // inicializa o som
        mp = MediaPlayer.create(this, R.raw.somurna);

        imageView = (ImageView) findViewById(R.id.imageView2);

        confirma = (Button) findViewById(R.id.confirma);
        confirma.setOnClickListener(this);

        corrige = (Button) findViewById(R.id.corrige);
        corrige.setOnClickListener(this);

        recebe = getIntent().getIntExtra("IDBUSCA", 0); // recebe o valor


        switch (recebe){
            case 1:
                imageView.setImageResource(R.drawable.abcd);
                break;
            case 2:
                imageView.setImageResource(R.drawable.crimeecastigo);
                break;
            case 3:
                imageView.setImageResource(R.drawable.donquixote);
                break;
            case 4:
                imageView.setImageResource(R.drawable.metamorfose);
                break;
        }

        // dá 3 segundos de vida para este layout
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Resultadobusca.this.finish();
            }
        }, 3000);
    }

    @Override
    public void onClick(View view) {
        Intent finaliza = new Intent(getApplicationContext(), Finaliza.class); // Cria o objeto que ira chamar a tela final caso o usuario clique em confirmar

        switch (view.getId()){

            case R.id.corrige:
                finish();
                break;


            case R.id.confirma:
                test = GetItemBusca.GetInstance().getTest().get(recebe-1);

                switch (recebe){
                    case 1:
                        test.setVoto();
                        break;
                    case 2:
                        test.setVoto();
                        break;
                    case 3:
                        test.setVoto();
                        break;
                    case 4:
                        test.setVoto();
                        break;
                }
                mp.start(); // inicia o som
                startActivity(finaliza);
                break;

        }

    }
}
