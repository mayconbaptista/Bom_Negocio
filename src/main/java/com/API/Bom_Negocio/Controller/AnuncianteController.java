package com.API.Bom_Negocio.Controller;

import com.API.Bom_Negocio.Model.DTO.AnuncianteDTO;
import com.API.Bom_Negocio.Model.Domain.Anunciante;
import com.API.Bom_Negocio.Model.ResponseException;
import com.API.Bom_Negocio.Service.Interfaces.AnuncianteIService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Optional;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/Anunciante")
public class AnuncianteController {

    private AnuncianteIService anuncianteIService;

    public AnuncianteController (AnuncianteIService anuncianteIService){

        this.anuncianteIService = anuncianteIService;
    }

    @PostMapping("/Public/Create/")
    public ResponseEntity<Object> create(@RequestBody @Valid AnuncianteDTO anuncianteDTO){

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(this.anuncianteIService.save(anuncianteDTO));
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseException(e.getMessage()));
        }
    }

    @GetMapping("/Private/GetAll/")
    public ResponseEntity<Object> getAll(){
        try {
            return ResponseEntity.ok(this.anuncianteIService.getAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseException(e.getMessage()));
        }
    }

    @GetMapping("/Private/GetById/")
    public ResponseEntity<Object> getById(@RequestParam("id") Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.anuncianteIService.getById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum elemento encontrado")));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/Private/GetByEmail/")
    public ResponseEntity<Object> getByEmail(@RequestParam("email") String email){

        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.anuncianteIService.getByEmail(email));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseException(e.getMessage()));
        }
    }


    @PutMapping("/Private/Update/")
    public ResponseEntity<Object> update (@RequestBody @Valid AnuncianteDTO anuncianteDTO){
        try{
            return ResponseEntity.ok(this.anuncianteIService.update(anuncianteDTO));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseException(e.getMessage()));
        }
    }

    @DeleteMapping ("/Private/Delete/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@RequestParam("id") Long id) {

        try{
            this.anuncianteIService.deleteById(id);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
