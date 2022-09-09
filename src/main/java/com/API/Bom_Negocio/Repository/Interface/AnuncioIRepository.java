package com.API.Bom_Negocio.Repository.Interface;

import com.API.Bom_Negocio.Model.Domain.Anunciante;
import com.API.Bom_Negocio.Model.Domain.Anuncio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AnuncioIRepository extends JpaRepository <Anuncio, Long>, JpaSpecificationExecutor<Anuncio> {

    @Transactional(readOnly = true)
    @Query("SELECT a FROM Anuncio as a WHERE a.anuncianteId = :anunciante")
    Page<Anuncio> findAllByAnuncianteId(Anunciante anunciante, Pageable pageable);
}
