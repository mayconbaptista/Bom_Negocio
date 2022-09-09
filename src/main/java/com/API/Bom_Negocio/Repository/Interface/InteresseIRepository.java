package com.API.Bom_Negocio.Repository.Interface;

import com.API.Bom_Negocio.Model.Domain.Anuncio;
import com.API.Bom_Negocio.Model.Domain.Interesse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface InteresseIRepository extends JpaRepository<Interesse, Long> {

    @Transactional(readOnly = true)
    List<Interesse> findByAnuncioId(Anuncio anuncio);
}
