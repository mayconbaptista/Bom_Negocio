package com.API.Bom_Negocio.Service.Implementation;

import com.API.Bom_Negocio.Model.DTO.CategoriaDTO;
import com.API.Bom_Negocio.Model.Domain.Categoria;
import com.API.Bom_Negocio.Repository.Interface.CategoriaIRepositoty;
import com.API.Bom_Negocio.Service.Interfaces.CategoriaIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService implements CategoriaIService {

    private CategoriaIRepositoty categoriaIRepositoty;

    public CategoriaService (CategoriaIRepositoty categoriaIRepositoty){
        this.categoriaIRepositoty = categoriaIRepositoty;
    }

    public List<CategoriaDTO> getAll () throws Exception {

        List<CategoriaDTO> lista = this.categoriaIRepositoty.findAll()
                .stream()
                .map(obj -> new CategoriaDTO(obj))
                .collect(Collectors.toList());

        return lista;
    }
}
