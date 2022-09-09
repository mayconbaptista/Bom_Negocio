package com.API.Bom_Negocio.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "enderecos")
@Getter
@Setter
public class Enderecos {

    @Id
    @GeneratedValue
    private Long id;
    private String cep;
    private String bairro;
    private String cidade;
    private String estado;
}
