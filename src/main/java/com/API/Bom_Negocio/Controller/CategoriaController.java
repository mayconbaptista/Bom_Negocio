package com.API.Bom_Negocio.Controller;

import com.API.Bom_Negocio.Model.ResponseException;
import com.API.Bom_Negocio.Service.Interfaces.CategoriaIService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Categoria")
public class CategoriaController {

    private CategoriaIService categoriaIService;

    public CategoriaController (CategoriaIService categoriaIService){

        this.categoriaIService = categoriaIService;
    }

    @GetMapping("/Public/Get/")
    public ResponseEntity<Object> get (){
        try{
            return ResponseEntity.ok(this.categoriaIService.getAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseException(e.getMessage()));
        }
    }
}
