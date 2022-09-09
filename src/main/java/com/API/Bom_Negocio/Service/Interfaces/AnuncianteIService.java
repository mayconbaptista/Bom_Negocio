package com.API.Bom_Negocio.Service.Interfaces;

import com.API.Bom_Negocio.Model.DTO.AnuncianteDTO;
import com.API.Bom_Negocio.Model.Domain.Anunciante;

import java.util.List;
import java.util.Optional;

public interface AnuncianteIService {

    public Anunciante save (AnuncianteDTO anuncianteDTO)throws Exception;
    public List<Anunciante> getAll ()throws Exception;
    public Optional<Anunciante> getById (Long id)throws Exception;
    public void deleteById (Long id) throws Exception;
    public Optional<AnuncianteDTO> getByEmail(String email) throws Exception;
    public Optional<AnuncianteDTO> update (AnuncianteDTO anuncianteDTO) throws Exception;
    public Optional<AnuncianteDTO> getByCpf (String cpf)throws Exception;
}
