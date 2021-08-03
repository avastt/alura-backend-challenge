package br.com.backend.alurachallenge.controller.form;

import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import br.com.backend.alurachallenge.entity.Categoria;
import br.com.backend.alurachallenge.repository.CategoriaRepository;

public class AtualizaCategoriaForm {
	@NotNull
	@NotEmpty
	private String titulo;

	@NotNull
	@NotEmpty
	private String cor;

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

	public Categoria converter() {

		return new Categoria(titulo, cor);
	}

	public Categoria atualizar(Long id, CategoriaRepository categoriaRepository) {

		Categoria categoria = categoriaRepository.getById(id);

		categoria.setTitulo(this.titulo);
		categoria.setCor(this.cor);

		return categoria;
	}
}
