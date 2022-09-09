package com.API.Bom_Negocio.Model.Domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "enderecos")
@Getter
@Setter
public class Enderecos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 9)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "[0-9]{8}")
    private String cep;

    @Column(length = 100)
    private String bairro;

    @Column(length = 100)
    private String cidade;

    @Column(length = 2)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "[A-Z]{2}")
    private String estado;
}
