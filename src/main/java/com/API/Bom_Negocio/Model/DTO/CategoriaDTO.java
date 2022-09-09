package com.API.Bom_Negocio.Model.DTO;

import com.API.Bom_Negocio.Model.Domain.Categoria;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoriaDTO {

    private Long id;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String nome;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String descricao;


    @JsonIgnore
    public CategoriaDTO (Categoria categoria){
        this.setId(categoria.getId());
        this.setNome(categoria.getNome());
        this.setDescricao(getDescricao());
    }

    @JsonIgnore
    public Categoria convert (){
        Categoria categoria = new Categoria();

        categoria.setId(this.getId());
        categoria.setNome(categoria.getNome());
        categoria.setDescricao(categoria.getDescricao());

        return categoria;
    }
}
