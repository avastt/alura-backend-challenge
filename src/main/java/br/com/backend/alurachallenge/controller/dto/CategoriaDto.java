package br.com.backend.alurachallenge.controller.dto;

import org.springframework.data.domain.Page;

import br.com.backend.alurachallenge.entity.Categoria;

public class CategoriaDto {

	private String titulo;
	private String cor;

	
	public CategoriaDto() {
		
	}
	
	public CategoriaDto(Categoria categoria) {
		super();
		this.titulo = categoria.getTitulo();
		this.cor = categoria.getCor();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public static Page<CategoriaDto> converter(Page<Categoria> categorias) {

		return categorias.map(CategoriaDto::new);
	}

}
