package com.iohann.find_tec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Detalhe extends AppCompatActivity {


    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private ImageButton voltar;
    private String nomeTec, cidadeTec;


    public Detalhe() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);
        voltar = (ImageButton) findViewById(R.id.btnvoltar);

        voltarClick();

        Intent i = getIntent();
        nomeTec = i.getExtras().getString("CIDADE_KEY");
        cidadeTec = i.getExtras().getString("NOME_KEY");


        conectaFirebase();
        TextView txtEmail = (TextView) findViewById(R.id.txtEmail); //Mapeando o componente textview
        TextView txtNome = (TextView) findViewById(R.id.txtNome); //Mapeando o componente textview
        TextView txtRua= (TextView) findViewById(R.id.txtEndereco); //Mapeando o componente textview
        TextView txtNumTelefone = (TextView) findViewById(R.id.txtNumero); //Mapeando o componente textview
        TextView txtPreco = (TextView) findViewById(R.id.txtPreco); //Mapeando o componente textview
        TextView txtEstado = (TextView) findViewById(R.id.txtEstado); //Mapeando o componente textview
        TextView txtCidade = (TextView) findViewById(R.id.txtCidade); //Mapeando o componente textview
        TextView txtDesc = (TextView) findViewById(R.id.txtDesc); //Mapeando o componente textview


        Item item = new Item();
        item.verificaUsuario(nomeTec, cidadeTec, txtDesc, txtEmail, txtNome, txtCidade, txtEstado, txtPreco, txtNumTelefone, txtRua);
    }

    private void voltarClick() {
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Detalhe.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void conectaFirebase() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }


}