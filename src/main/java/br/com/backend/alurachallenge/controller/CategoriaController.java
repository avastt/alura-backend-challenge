package br.com.backend.alurachallenge.controller;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.backend.alurachallenge.controller.dto.CategoriaDto;
import br.com.backend.alurachallenge.controller.form.AtualizaCategoriaForm;
import br.com.backend.alurachallenge.controller.form.CategoriaForm;
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
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaDto> retornaCategoria (@PathVariable Long id) {

		
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		
		if(categoria.isPresent()) {
			

			return ResponseEntity.ok(new CategoriaDto(categoria.get()));
		} 
		
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<CategoriaDto> cadastrarCategoria (@RequestBody @Valid CategoriaForm categoriaForm) {
		
		Categoria categoria = categoriaForm.converter();
		categoriaRepository.save(categoria);
		
		
		return new ResponseEntity<CategoriaDto>(new CategoriaDto(categoria), HttpStatus.CREATED);
	}
	
	@PutMapping("/atualiza/{id}")
	@Transactional
	public ResponseEntity<CategoriaDto> atualizarCategoria (@PathVariable Long id, @RequestBody @Valid AtualizaCategoriaForm atualizaCategoriaForm) {
		
		Optional<Categoria> optional = categoriaRepository.findById(id);
		
		if(optional.isPresent()) {
			
			Categoria categoria = atualizaCategoriaForm.atualizar(id, categoriaRepository);
			categoriaRepository.save(categoria);
			
			return new ResponseEntity<CategoriaDto>(new CategoriaDto(categoria), HttpStatus.OK);
		}
		//return ResponseEntity.notFound().build();
		return new ResponseEntity<CategoriaDto>(new CategoriaDto(), HttpStatus.NOT_FOUND);
	}
	
}
