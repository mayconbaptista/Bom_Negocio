package com.API.Bom_Negocio.Service.Implementation;

import com.API.Bom_Negocio.Model.DTO.AnuncianteDTO;
import com.API.Bom_Negocio.Model.Domain.Anunciante;
import com.API.Bom_Negocio.Repository.Interface.AnuncianteIRepository;
import com.API.Bom_Negocio.Service.Interfaces.AnuncianteIService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class AnuncianteService implements AnuncianteIService {

    private AnuncianteIRepository anuncianteIRepository;

    public AnuncianteService(AnuncianteIRepository anuncianteIRepository){
        this.anuncianteIRepository = anuncianteIRepository;
    }

    public Anunciante save (AnuncianteDTO anuncianteDTO)throws Exception{
        return this.anuncianteIRepository.save(anuncianteDTO.convert());
    }

    public List<Anunciante> getAll ()throws Exception{
        return this.anuncianteIRepository.findAll();
    }

    public Optional<Anunciante> getById (Long id)throws Exception{
        return this.anuncianteIRepository.findById(id);
    }

    public Optional<AnuncianteDTO> getByCpf (String cpf)throws Exception{
        return Optional.ofNullable(this.anuncianteIRepository.findByCpf(cpf))
                .map(obj -> new AnuncianteDTO(obj));
    }

    public Optional<AnuncianteDTO> getByEmail(String email) throws Exception{

        if(!Pattern.matches("%@%", email)) throw new Exception("Formato de email inválido");

        return Optional.ofNullable(this.anuncianteIRepository.findByEmail(email))
                .map(obj -> new AnuncianteDTO(obj));
    }


    public Optional<AnuncianteDTO> update(AnuncianteDTO anuncianteDTO) throws Exception {
        Optional<Anunciante> optionalAnunciante = Optional.ofNullable(this.anuncianteIRepository.findByCpf(anuncianteDTO.convert().getCpf()));

        if(!optionalAnunciante.isPresent()) throw new Exception("Anunciante não encontrado");

        optionalAnunciante.get().setNome(anuncianteDTO.getNome());
        optionalAnunciante.get().setTelefone(anuncianteDTO.getTelefone());

        return Optional.ofNullable(this.anuncianteIRepository.save(optionalAnunciante.get()))
                .map(obj -> new AnuncianteDTO(obj));
    }


    public void deleteById (Long id) throws Exception{
        Optional<Anunciante> optionalAnunciante = this.anuncianteIRepository.findById(id);

        if(!optionalAnunciante.isPresent()) throw new Exception("O anunciante não existe no BD");

        this.anuncianteIRepository.deleteById(id);
    }
}
