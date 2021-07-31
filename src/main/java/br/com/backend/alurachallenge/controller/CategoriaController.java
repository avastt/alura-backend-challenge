package br.com.backend.alurachallenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.backend.alurachallenge.controller.dto.CategoriaDto;
import br.com.backend.alurachallenge.entity.Categoria;
import br.com.backend.alurachallenge.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping
	public Page<CategoriaDto> listaCategorias (
			@PageableDefault(sort = "id", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {

		Page<Categoria> categorias = categoriaRepository.findAll(paginacao);
		return CategoriaDto.converter(categorias);
	}
}
