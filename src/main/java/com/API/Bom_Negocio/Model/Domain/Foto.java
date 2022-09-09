package com.API.Bom_Negocio.Model.Domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "foto")
@Getter
@Setter
public class Foto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String nomeArqFoto;

    @ManyToOne
    @JoinColumn(name = "anuncioId", nullable = false)
    private Anuncio anuncioId;
}
