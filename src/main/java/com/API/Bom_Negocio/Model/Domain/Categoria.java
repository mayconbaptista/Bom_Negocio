package com.API.Bom_Negocio.Model.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categoria")
@Getter
@Setter
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(length = 500, nullable = false)
    private String descricao;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoriaId")
    private List<Anuncio> anuncios;
}
