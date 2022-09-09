package com.API.Bom_Negocio.Service.Interfaces;

import com.API.Bom_Negocio.Model.DTO.InteresseDTO;

import java.util.List;

public interface InteresseIService {

    public List<InteresseDTO> getByAnuncio (Long anuncioId) throws Exception;
}
