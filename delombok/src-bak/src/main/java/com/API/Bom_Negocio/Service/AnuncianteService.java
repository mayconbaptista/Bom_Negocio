package com.API.Bom_Negocio.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.API.Bom_Negocio.Model.*;
import com.API.Bom_Negocio.Repository.Interface.*;
import com.API.Bom_Negocio.Repository.Concrete.*;

@Service
public class AnuncianteService {

    private AnuncianteIRepository anuncianteIRepository;

    AnuncianteService(AnuncianteRepository anuncianteRepository){
        this.anuncianteIRepository = anuncianteRepository;
    }

    public void create(Anunciante anunciante){
        return;
    }
}
