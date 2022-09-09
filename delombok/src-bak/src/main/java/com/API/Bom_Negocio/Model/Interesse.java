package com.API.Bom_Negocio.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "interesse")
@Getter
@Setter
public class Interesse {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String mensagem;
    private Date dataHora;
    private String contato;

    @ManyToOne
    private Anuncio anuncioId;
}
