package com.API.Bom_Negocio.Service.Interfaces;

import com.API.Bom_Negocio.Model.DTO.AnuncioDTO;
import com.API.Bom_Negocio.Model.Domain.Anuncio;

import java.util.List;
import java.util.Optional;

public interface AnuncioIService {

    public AnuncioDTO save (AnuncioDTO anuncioDTO)throws Exception;

    public List<AnuncioDTO> getAllByAnuncianteId (Long id, int page) throws Exception;

    public List<AnuncioDTO> getByDescricoesSpec (List<String> descricoes, int page) throws Exception;


    public Optional<AnuncioDTO> update (AnuncioDTO anuncioDTO) throws Exception ;

    public Optional<AnuncioDTO> getById (Long id) throws Exception ;

    public void deleteById (Long id) throws Exception;

    public List<AnuncioDTO> getAll () throws Exception;
}
