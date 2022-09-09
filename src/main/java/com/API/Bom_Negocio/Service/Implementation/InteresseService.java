package com.API.Bom_Negocio.Service.Implementation;

import com.API.Bom_Negocio.Model.DTO.InteresseDTO;
import com.API.Bom_Negocio.Model.Domain.Anuncio;
import com.API.Bom_Negocio.Repository.Interface.AnuncioIRepository;
import com.API.Bom_Negocio.Repository.Interface.InteresseIRepository;
import com.API.Bom_Negocio.Service.Interfaces.InteresseIService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InteresseService implements InteresseIService {

    private InteresseIRepository interesseIRepository;

    private AnuncioIRepository anuncioIRepository;

    public InteresseService (InteresseIRepository interesseIRepository,
                             AnuncioIRepository anuncioIRepository){

        this.interesseIRepository = interesseIRepository;
        this.anuncioIRepository = anuncioIRepository;
    }


    public List<InteresseDTO> getByAnuncio (Long anuncioId) throws Exception{

        Optional <Anuncio> optionalAnuncio= this.anuncioIRepository.findById(anuncioId);

        if(!optionalAnuncio.isPresent()) throw new Exception("Anuncio inexistente id = " + anuncioId);

        return this.interesseIRepository.findByAnuncioId(optionalAnuncio.get())
                .stream()
                .map(obj -> new InteresseDTO(obj))
                .collect(Collectors.toList());
    }
}
