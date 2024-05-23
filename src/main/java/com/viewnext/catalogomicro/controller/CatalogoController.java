package com.viewnext.catalogomicro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viewnext.catalogomicro.model.Catalogo;
import com.viewnext.catalogomicro.services.ICatalogoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/catalogo")
public class CatalogoController {

	private ICatalogoService catalogoService;

	public CatalogoController(ICatalogoService catalogoService) {
		this.catalogoService = catalogoService;
	}

	@Value("${server.port}")
	private Integer port;

	@GetMapping("/list")
	public ResponseEntity<List<Catalogo>> getAll() {

		List<Catalogo> listCatalogo = catalogoService.findAll();
		return ResponseEntity.ok(listCatalogo);
	}

	@GetMapping("/list/producto/{id}")
	public Optional<Catalogo> getProducto(@PathVariable Long id) throws NotFoundException {
		log.info("<---- Mostrando el producto con id {} ---->", id);
		return Optional.of(catalogoService.findById(id).orElseThrow(NotFoundException::new));
	}

}
