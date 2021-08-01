package br.com.backend.alurachallenge.controller.form;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import br.com.backend.alurachallenge.entity.Categoria;
import br.com.backend.alurachallenge.entity.Video;
import br.com.backend.alurachallenge.repository.CategoriaRepository;
import br.com.backend.alurachallenge.repository.VideoRepository;
import javassist.NotFoundException;

public class AtualizaVideoForm {
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

	public Video atualizar(Long id, VideoRepository videoRepository, CategoriaRepository categoriaRepository) {

		Video video = videoRepository.getById(id);
		video.setTitulo(this.titulo);
		video.setDescricao(this.descricao);
		video.setUrl(this.url);

		try {
			Categoria categoria = categoriaRepository.getById(categoriaId);
			video.setCategoria(categoria);
		} catch (EntityNotFoundException e) {
			e.getMessage();
		}

		return video;
	}
}
