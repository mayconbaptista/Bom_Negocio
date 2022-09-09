package com.API.Bom_Negocio.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "anunciante")
@Getter
@Setter
public class Anunciante {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String senhaHash;
    private String telefone;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "anuncianteId")
    private List<Anuncio> anuncios;
}
