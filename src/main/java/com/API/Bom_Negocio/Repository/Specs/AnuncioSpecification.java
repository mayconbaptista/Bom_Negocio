package com.API.Bom_Negocio.Repository.Specs;

import com.API.Bom_Negocio.Model.Domain.Anuncio;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class AnuncioSpecification {

    public static Specification<Anuncio> descricaoLike (String descricao){
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("descricao"), "%" + descricao + "%");
    }
}
