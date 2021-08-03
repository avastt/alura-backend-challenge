package br.com.backend.alurachallenge.controller.form;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import br.com.backend.alurachallenge.entity.Categoria;
import br.com.backend.alurachallenge.entity.Video;
import br.com.backend.alurachallenge.repository.CategoriaRepository;

public class VideoForm {

	@NotNull
	@NotEmpty
	private String descricao;

	@NotNull
	@NotEmpty
	private String titulo;

	@NotNull
	@NotEmpty
	private String url;

	private Long categoriaId;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}

	public Video converter(CategoriaRepository categoriaRepository) {

		Long aux = 1L;

		if (categoriaId != null) {
			aux = categoriaId;
		}

		Categoria categoria = categoriaRepository.getById(aux);

		return new Video(descricao, titulo, url, categoria);

	}

}
