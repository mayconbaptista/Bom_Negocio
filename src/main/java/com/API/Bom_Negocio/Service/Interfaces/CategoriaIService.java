package com.API.Bom_Negocio.Service.Interfaces;

import com.API.Bom_Negocio.Model.DTO.CategoriaDTO;

import java.util.List;

public interface CategoriaIService{

    public List<CategoriaDTO> getAll () throws Exception;
}
