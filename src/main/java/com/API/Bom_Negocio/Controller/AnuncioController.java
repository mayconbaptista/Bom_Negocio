package com.API.Bom_Negocio.Controller;

import com.API.Bom_Negocio.Model.DTO.AnuncioDTO;
import com.API.Bom_Negocio.Model.ResponseException;
import com.API.Bom_Negocio.Service.Interfaces.AnuncioIService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Anuncio")
public class AnuncioController {

    private AnuncioIService anuncioIService;

    public AnuncioController (AnuncioIService anuncioIService){

        this.anuncioIService = anuncioIService;
    }

    @PostMapping ("/Private/Create/")
    public ResponseEntity<Object> create (@RequestBody @Valid AnuncioDTO anuncioDTO){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(this.anuncioIService.save(anuncioDTO));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseException(e.getMessage()));
        }
    }

    @GetMapping("/Private/GetByAnuncianteId/")
    public ResponseEntity<Object> getByAnuncianteId(@RequestParam("id") Long id,
                                                    @RequestParam("page") int page){

        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.anuncioIService.getAllByAnuncianteId(id, page));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error " + e.getMessage());
        }
    }


    @GetMapping("/Public/GetByDescricao/")
    public ResponseEntity<Object> getByDescricao (@RequestParam("page") int page,
                                                  @RequestBody List<String> descricoes){

        if(descricoes.size() == 0) ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseException("Nenhuma descrição foi informada"));

        try{
            return ResponseEntity.ok(this.anuncioIService.getByDescricoesSpec(descricoes, page));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseException(e.getMessage()));
        }
    }

    @DeleteMapping("/Private/Delete/")
    public ResponseEntity<Object> delete (@RequestParam("id") Long id){

        try{
            this.anuncioIService.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(id);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseException(e.getMessage()));
        }
    }

    @PutMapping("/Private/Update/")
    public ResponseEntity<Object> update(@RequestBody @Valid AnuncioDTO anuncioDTO){

        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.anuncioIService.update(anuncioDTO));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseException(e.getMessage()));
        }
    }
}
