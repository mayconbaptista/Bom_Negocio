package com.API.Bom_Negocio.Model.Domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "anuncio")
@Getter
@Setter
public class Anuncio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String titulo;

    @Column(length = 500)
    private String descricao;

    // @Column(precision = 20, scale = 2)
    private float preco;

    private LocalDateTime dataHora;

    @Column(length = 8, nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "[0-9]{8}")
    private String cep;

    @Column(length = 100, nullable = false)
    private String bairro;

    @Column(length = 100, nullable = false)
    private String cidade;

    @Column(length = 2, nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "[A-Z]{2}")
    private String estado;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "categoriaId", nullable = false)
    private Categoria categoriaId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "anuncianteId", nullable = false)
    private Anunciante anuncianteId;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "anuncioId")
    private List <Foto> fotos;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "anuncioId")
    private List<Interesse> interesses;
}
