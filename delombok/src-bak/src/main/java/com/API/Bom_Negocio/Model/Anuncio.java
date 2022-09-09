package com.API.Bom_Negocio.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "anuncio")
@Getter
@Setter
public class Anuncio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String titulo;
    private String descricao;
    private float preco;
    private Date dataHora;
    private String cep;
    private String bairro;
    private String cidade;
    private String estado;

    @ManyToOne
    private Categoria categoriaId;
    @ManyToOne
    private Anunciante anuncianteId;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "anuncioId")
    private List <Foto> fotos;
    @OneToMany
    @JoinColumn(name = "anuncioId")
    private List<Interesse> interesses;
}
