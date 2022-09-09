package com.API.Bom_Negocio.Controller;

import org.springframework.web.bind.annotation.*;

@RestController("/Anuncio")
public class AnuncioController {

    @GetMapping("/Anuncio/GetAll/")
    public String getAll(){
        return "hello world!";
    }

    @GetMapping("/Anuncio/GetById/{id}")
    public String getById(Long id){
        return "Ok";
    }

    @PostMapping ("/Anuncio/Create/")
    public String create (){
        return "Create";
    }

    @DeleteMapping("/Anuncio/Delete/")
    public String delete (Long id){

        return "delete";

    }

    @PutMapping("/Anuncio/Update")
    public String update(){
        return "Update";
    }
}
