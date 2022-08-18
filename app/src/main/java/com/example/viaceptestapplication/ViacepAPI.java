package com.example.viaceptestapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;

public interface ViacepAPI {

        @GET("ws/{cep}/json")
        Call<Endereco> getEndereco(
                @Path("cep")String cep

        );
}
