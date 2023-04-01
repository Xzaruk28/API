package com.example.api.Listas;

import java.io.Serializable;

public class categorias implements Serializable {
    public categorias(String social) {
        this.generos = social;
    }

    public String getGeneros() {
        return generos;
    }

    public void setGeneros(String generos) {
        this.generos = generos;
    }

    private String generos;


}
