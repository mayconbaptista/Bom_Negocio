package com.API.Bom_Negocio.Model.Domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "interesse")
@Getter
@Setter
public class Interesse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500)
    private String mensagem;

    private LocalDateTime dataHora;

    @Column(length = 11)
    private String contato;

    @ManyToOne
    @JoinColumn(name = "anuncioId", nullable = false)
    private Anuncio anuncioId;
}
