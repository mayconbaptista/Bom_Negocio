package com.API.Bom_Negocio.Repository.Interface;

import com.API.Bom_Negocio.Model.Domain.Anunciante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnuncianteIRepository extends JpaRepository<Anunciante, Long> {

    Anunciante findByEmail(String email);

    Anunciante findByCpf(String cpf);

    void deleteByCpf(String cpf);
}
