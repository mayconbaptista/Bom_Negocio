package com.API.Bom_Negocio.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "foto")
@Getter
@Setter
public class Foto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nomeArqFoto;

    @ManyToOne
    private Anuncio anuncioId;
}
