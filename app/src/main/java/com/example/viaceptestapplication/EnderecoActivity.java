package com.example.viaceptestapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EnderecoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endereco);

        ViacepAPI api = getRetrofit().create(ViacepAPI.class);
        Button btPesquisar = findViewById(R.id.btPesquisar);
        EditText idCep=findViewById(R.id.idCEP);
        EditText idLogradouro=findViewById(R.id.idLogradouro);
        EditText idComplemento=findViewById(R.id.idComplemento);
        EditText idBairro=findViewById(R.id.idBairro);
        EditText idLocalidade=findViewById(R.id.idLocalidade);
        EditText idUf=findViewById(R.id.idUf);
        btPesquisar.setOnClickListener(new View.OnClickListener() {

                                           @Override
                                           public void onClick(View view) {
                                                String cep=idCep.getText().toString();
                                                api.getEndereco(cep).enqueue(new Callback<Endereco>() {
                                                    @Override
                                                    public void onResponse(Call<Endereco> call, Response<Endereco> response) {
                                                        Endereco endereco=response.body();
                                                        if (
                                                                endereco==null
                                                        ){
                                                            return;
                                                        }
                                                        idLogradouro.setText(response.body().logradouro);
                                                        idComplemento.setText(response.body().complemento);
                                                        idBairro.setText(response.body().bairro);
                                                        idLocalidade.setText(response.body().localidade);
                                                        idUf.setText(response.body().uf);
                                                    }


                                                    @Override
                                                    public void onFailure(Call<Endereco> call, Throwable t) {

                                                    }
                                                });

                                           }
                                       }
        );
    }

    private Retrofit getRetrofit() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new Retrofit.Builder()
                .baseUrl("https://viacep.com.br/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().addInterceptor(interceptor).build())
                .build();


    }
}