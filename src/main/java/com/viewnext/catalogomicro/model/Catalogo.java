package com.viewnext.catalogomicro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Catalogo {

	@Id
	private Long id;
	private String name;
	private String description;

}
