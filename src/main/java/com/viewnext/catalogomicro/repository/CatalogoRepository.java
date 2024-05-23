package com.viewnext.catalogomicro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viewnext.catalogomicro.model.Catalogo;

@Repository
public interface CatalogoRepository extends JpaRepository<Catalogo, Long> {

}
