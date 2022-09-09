package com.API.Bom_Negocio.Model.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FotoDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotEmpty(message = "{campo.nomeArqFoto.obrigatorio}")
    private String nomeArqFoto;

    @NotNull(message = "campo.anuncioId.obrigatorio")
    private Long anuncioId;
}

