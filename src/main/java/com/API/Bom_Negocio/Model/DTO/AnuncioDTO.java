package com.API.Bom_Negocio.Model.DTO;

import com.API.Bom_Negocio.Model.Domain.Anuncio;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AnuncioDTO {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id;

    @NotEmpty(message = "{campo.titulo.obrigatorio}")
    private String titulo;

    @NotEmpty(message = "{campo.descricao.obrigatorio}")
    private String descricao;

    @NotNull(message = "{campo.preco.obrigatorio}")
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT)
    private float preco;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dataHora;

    @NotEmpty(message = "{campo.cep.obrigatori}")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "[0-9]{8}")
    private String cep;

    @NotEmpty(message = "{campo.bairro.obrigatorio}")
    private String bairro;

    @NotEmpty(message = "{campo.cidade.obrigatorio}")
    private String cidade;

    @NotEmpty(message = "{campo.estado.obrigatorio}")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "[A-Z]{2}")
    private String estado;

    @NotNull(message = "{campo.categoriaId.obrigatorio}")
    private Long categoriaId;

    @NotNull(message = "{campo.anuncianteId.obrigatorio}")
    private Long anuncianteId;

    @JsonIgnore
    public AnuncioDTO(Anuncio anuncio){
        this.setTitulo(anuncio.getTitulo());
        this.setDescricao(anuncio.getDescricao());
        this.setPreco(anuncio.getPreco());
        this.setDataHora(anuncio.getDataHora());
        this.setCep(anuncio.getCep());
        this.setBairro(anuncio.getBairro());
        this.setCidade(anuncio.getCidade());
        this.setEstado(anuncio.getEstado());
        this.setAnuncianteId(anuncio.getAnuncianteId().getId());
        this.setCategoriaId(anuncio.getCategoriaId().getId());
    }

    @JsonIgnore
    public Anuncio convert (){
        Anuncio anuncio = new Anuncio();
        anuncio.setTitulo(this.getTitulo());
        anuncio.setDescricao(this.getDescricao());
        anuncio.setPreco(this.getPreco());
        anuncio.setDataHora(LocalDateTime.now());
        anuncio.setCep(this.getCep());
        anuncio.setBairro(this.getBairro());
        anuncio.setCidade(this.getCidade());
        anuncio.setEstado(this.getEstado());
        anuncio.setAnuncianteId(null);
        anuncio.setCategoriaId(null);

        return  anuncio;
    }
}
