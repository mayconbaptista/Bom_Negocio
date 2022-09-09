package com.API.Bom_Negocio.Model;

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
    @GeneratedValue
    private Long id;
    private int codigo;
    private String descricao;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoriaId")
    private List<Anuncio> anuncios;
}
