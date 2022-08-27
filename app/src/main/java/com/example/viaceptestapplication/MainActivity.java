package com.example.viaceptestapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Endereco> enderecoList = new ArrayList<>();
    private EnderecoAdapter adapter;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("");
        adapter = new EnderecoAdapter(this, enderecoList);
        Button btAdicionar=findViewById(R.id.btAdicionar);
        RecyclerView rRecycle=findViewById(R.id.rRecycle);
        rRecycle.setAdapter(adapter);
        rRecycle.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        btAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this, EnderecoActivity.class),1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == RESULT_OK) {
            Endereco endereco = (Endereco) data.getSerializableExtra("Endereco");
            enderecoList.add(endereco);
            adapter.notifyDataSetChanged();



        }
    }
}