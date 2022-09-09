package com.API.Bom_Negocio.Model.Domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(length = 11,unique = true, nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "[0-9]{11}")
    private String cpf;

    @Column(length = 100, unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String senhaHash;

    @Column(length = 11)
    @JsonFormat(pattern = "[0-9]{11}")
    private String telefone;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "anuncianteId")
    private List<Anuncio> anuncios;
}
