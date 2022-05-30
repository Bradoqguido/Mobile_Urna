package com.example.jefer.urnatesi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Apuracao extends AppCompatActivity {

    private TextView A1948, CRIMEECASTIGO, DONQUIXOTE, METAMORFOSE, BRANCO, NULO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apuracao);

        A1948 = (TextView) findViewById(R.id.A1948);
        CRIMEECASTIGO = (TextView) findViewById(R.id.CRIMEECASTIGO);
        DONQUIXOTE = (TextView) findViewById(R.id.DONQUIXOTE);
        METAMORFOSE = (TextView) findViewById(R.id.METAMORFOSE);
        BRANCO = (TextView) findViewById(R.id.BRANCO);
        NULO = (TextView) findViewById(R.id.NULO);

        A1948.setText(getIntent().getIntExtra("A1984", 0) + " Votos");
        CRIMEECASTIGO.setText(getIntent().getIntExtra("CRIMEECASTIGO", 0) + " Votos");
        DONQUIXOTE.setText(getIntent().getIntExtra("DONQUIXOTE", 0) + " Votos");
        METAMORFOSE.setText(getIntent().getIntExtra("METAMORFOSE", 0) + " Votos");
        BRANCO.setText(getIntent().getIntExtra("BRANCO", 0) + " Votos");
        NULO.setText(getIntent().getIntExtra("NULO", 0) + " Votos");

    }
}
