package com.API.Bom_Negocio.Repository.Interface;

import com.API.Bom_Negocio.Model.Domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaIRepositoty extends JpaRepository <Categoria, Long> {

}
