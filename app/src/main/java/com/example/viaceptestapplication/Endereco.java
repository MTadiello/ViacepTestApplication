package com.example.viaceptestapplication;

import java.io.Serializable;

public class Endereco implements Serializable {

        String cep, logradouro, complemento, bairro, localidade, uf, ibge, gia, ddd, siafi;

        @Override
        public String toString() {
                return cep+" - "+logradouro+", "+bairro+", "+ uf;
        }
}
