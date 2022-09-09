package com.API.Bom_Negocio.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.API.Bom_Negocio.Model.*;
import com.API.Bom_Negocio.Service.AnuncianteService;

@RestController("/Anunciante")
public class AnuncianteController {

    @Autowired
    private AnuncianteService anuncianteService;

    @GetMapping("/Anunciante/GetAll")
    public String getAll(){
        return "DevTools ok";
    }
}
