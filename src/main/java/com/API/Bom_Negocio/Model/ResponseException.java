package com.API.Bom_Negocio.Model;

import lombok.Getter;

@Getter
public class ResponseException{

    private String menssagem;

    public ResponseException (String menssagem){
        this.menssagem = menssagem;
    }
}
