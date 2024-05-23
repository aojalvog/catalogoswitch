package com.viewnext.catalogomicro.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.viewnext.catalogomicro.handler.NotFoundException;
import com.viewnext.catalogomicro.model.Catalogo;
import com.viewnext.catalogomicro.repository.CatalogoRepository;
import com.viewnext.catalogomicro.services.ICatalogoService;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class CatalogoServiceImpl implements ICatalogoService {

	private CatalogoRepository catalogoRepository;

	public CatalogoServiceImpl(CatalogoRepository catalogoRepository) {
		this.catalogoRepository = catalogoRepository;
	}

	@Override
	public List<Catalogo> findAll() {
		log.info("<---- Listando el catalogo ---->");
		return catalogoRepository.findAll();
	}

	@Override
	public Optional<Catalogo> findById(Long id) {
		log.info("<---- Comprobando si el producto con id {} existe ---->", id);
		return Optional.ofNullable(catalogoRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Producto no encontrado con id " + id)));
	}

}
