package com.API.Bom_Negocio.Model.DTO;

import com.API.Bom_Negocio.Model.Domain.Anunciante;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AnuncianteDTO {
    private Long id;

    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String nome;

    @NotEmpty(message = "{campo.cpf.obrigatorio}")
    @CPF(message = "{campo.cpf.invalido}")
    private String cpf;

    @NotEmpty(message = "{campo.email.obrigatorio}")
    @JsonFormat(pattern = "%@%")
    @Email(message = "{campo.email.invalido}")
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY, required = true)
    @NotEmpty(message = "{campo.senha.obrigatorio}")
    private String senha;

    @NotEmpty(message = "{campo.telefone.obrigatorio}")
    @JsonFormat(pattern = "[0-9]{11}")
    private String telefone;

    @JsonIgnore
    public AnuncianteDTO(Anunciante anunciante){
        this.setId(anunciante.getId());
        this.setNome(anunciante.getNome());
        this.setCpf(anunciante.getCpf());
        this.setEmail(anunciante.getEmail());
        this.setTelefone(anunciante.getTelefone());
    }

    @JsonIgnore
    public Anunciante convert (){
        Anunciante anunciante = new Anunciante();

        anunciante.setId(this.getId());
        anunciante.setNome(this.getNome());
        anunciante.setCpf(this.getCpf());
        anunciante.setEmail(this.getEmail());
        anunciante.setSenhaHash(this.getSenha());
        anunciante.setTelefone(this.getTelefone());

        return anunciante;
    }
}

