package com.API.Bom_Negocio.Service.Implementation;

import com.API.Bom_Negocio.Model.DTO.AnuncioDTO;
import com.API.Bom_Negocio.Model.Domain.Anunciante;
import com.API.Bom_Negocio.Model.Domain.Anuncio;
import com.API.Bom_Negocio.Model.Domain.Categoria;
import com.API.Bom_Negocio.Repository.Interface.AnuncianteIRepository;
import com.API.Bom_Negocio.Repository.Interface.AnuncioIRepository;
import com.API.Bom_Negocio.Repository.Interface.CategoriaIRepositoty;
import com.API.Bom_Negocio.Service.Interfaces.AnuncioIService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnuncioService implements AnuncioIService{

    private AnuncioIRepository anuncioIRepository;

    private CategoriaIRepositoty categoriaIRepositoty;

    private AnuncianteIRepository anuncianteIRepository;

    public AnuncioService (AnuncioIRepository anuncioIRepository,
                           AnuncianteIRepository anuncianteIRepository,
                           CategoriaIRepositoty categoriaIRepositoty){

        this.anuncioIRepository = anuncioIRepository;
        this.anuncianteIRepository = anuncianteIRepository;
        this.categoriaIRepositoty = categoriaIRepositoty;
    }

    public AnuncioDTO save (AnuncioDTO anuncioDTO)throws Exception{

        Anuncio anuncio = anuncioDTO.convert();

        Optional <Anunciante> optionalAnunciante = this.anuncianteIRepository.findById(anuncioDTO.getAnuncianteId());

        if(!optionalAnunciante.isPresent())
            throw new Exception("Anunciante não existe");

        Optional <Categoria> optionalCategoria = this.categoriaIRepositoty.findById(anuncioDTO.getCategoriaId());

        if(!optionalCategoria.isPresent())
            throw new Exception("Categoria Inexistente");

        anuncio.setCategoriaId(optionalCategoria.get());
        anuncio.setAnuncianteId(optionalAnunciante.get());

        return new AnuncioDTO(this.anuncioIRepository.save(anuncio));
    }

    public List<AnuncioDTO> getAllByAnuncianteId (Long id, int page) throws Exception{

        Optional <Anunciante> optionalAnunciante = this.anuncianteIRepository.findById(id);

        if(!optionalAnunciante.isPresent()) throw new Exception ("Não Existe o anunciante com id = " + id);

        List<AnuncioDTO> lista = new ArrayList<>();

        this.anuncioIRepository.findAllByAnuncianteId(optionalAnunciante.get(),  PageRequest.of(page, 10))
                .forEach(obj -> lista.add(new AnuncioDTO(obj)));

        return lista;
    }// função modelo!

    public List<AnuncioDTO> getByDescricoesSpec (List<String> descricoes, int page) throws Exception {

        Specification <Anuncio> anuncioSpec = Specification.where((root, query, CB) -> CB.conjunction());

        for(String desc : descricoes){
            anuncioSpec = anuncioSpec.and(((root, query, criteriaBuilder) -> {
                return criteriaBuilder.like(root.get("descricao"),"%" + desc.trim() + "%");
            }));
        }

        return this.anuncioIRepository.findAll(anuncioSpec, PageRequest.of(page, 10))
                .stream()
                .map(obj -> new AnuncioDTO(obj))
                .collect(Collectors.toList());
    }


    public Optional<AnuncioDTO> update (AnuncioDTO anuncioDTO) throws Exception {

        Optional<Anuncio> anuncioExist = this.anuncioIRepository.findById(anuncioDTO.getId());

        if(!anuncioExist.isPresent()) throw new Exception("a anuncio não existe no BD");

        Anuncio anuncio = anuncioExist.get();
        anuncio.setTitulo(anuncioDTO.getTitulo());
        anuncio.setDescricao(anuncioDTO.getDescricao());
        anuncio.setCep(anuncioDTO.getCep());
        anuncio.setBairro(anuncioDTO.getBairro());
        anuncio.setCidade(anuncioDTO.getCidade());
        anuncio.setBairro(anuncioDTO.getBairro());
        anuncio.setPreco(anuncioDTO.getPreco());


        return Optional.ofNullable(this.anuncioIRepository.save(anuncio))
                .map(obj -> new AnuncioDTO(obj));
    }

    public Optional<AnuncioDTO> getById (Long id) throws Exception {
        Optional <AnuncioDTO> optionalAnuncioDTO = this.anuncioIRepository.findById(id)
                .map(obj -> new AnuncioDTO(obj));

        return optionalAnuncioDTO;
    }

    public void deleteById (Long id) throws Exception{

        Optional <Anuncio> optional = this.anuncioIRepository.findById(id);

        if(!optional.isPresent()) throw new Exception("Anuncio não encontrado");

        this.anuncioIRepository.deleteById(id);
    }

    public List<AnuncioDTO> getAll () throws Exception {

        return this.anuncioIRepository.findAll()
                .stream()
                .map(obj -> new AnuncioDTO(obj))
                .collect(Collectors.toList());
    }
}
