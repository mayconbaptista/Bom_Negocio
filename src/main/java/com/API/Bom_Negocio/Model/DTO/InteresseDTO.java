package com.API.Bom_Negocio.Model.DTO;

import com.API.Bom_Negocio.Model.Domain.Interesse;
import com.fasterxml.jackson.annotation.JsonFormat;
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
public class InteresseDTO {

    private Long id;

    @NotEmpty(message = "{campo.mensagem.obrigatorio}")
    private String mensagem;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dataHora;

    @NotNull(message = "{campo.telefone.obrigatorio}")
    @JsonFormat(pattern = "[0-9]{11}", shape = JsonFormat.Shape.STRING)
    private String contato;

    @NotNull(message = "{campo.anuncioId.obrigatorio}")
    private Long anuncioId;

    public InteresseDTO (Interesse interesse){
        this.setId(interesse.getId());
        this.setMensagem(interesse.getMensagem());
        this.setContato(interesse.getMensagem());
        this.setAnuncioId(interesse.getAnuncioId().getId());
        this.setDataHora(interesse.getDataHora());
    }
}
