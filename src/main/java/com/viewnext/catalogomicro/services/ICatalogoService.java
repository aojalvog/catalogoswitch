package com.viewnext.catalogomicro.services;

import java.util.List;
import java.util.Optional;

import com.viewnext.catalogomicro.model.Catalogo;

public interface ICatalogoService {

	public List<Catalogo> findAll();

	public Optional<Catalogo> findById(Long id);

}
