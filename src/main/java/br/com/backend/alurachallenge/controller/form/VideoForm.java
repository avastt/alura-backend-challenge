package br.com.backend.alurachallenge.controller.form;

import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import br.com.backend.alurachallenge.entity.Video;
import br.com.backend.alurachallenge.repository.VideoRepository;

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

	public Video converter() {

		return new Video(descricao, titulo, url);
	}

}
