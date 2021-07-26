package br.com.backend.alurachallenge.controller.dto;

import org.springframework.data.domain.Page;

import br.com.backend.alurachallenge.entity.Video;

public class VideoDto {

	private Long id;
	private String titulo;
	private String descricao;
	private String url;

	
	
	public VideoDto() {
		super();
	}

	public VideoDto(Video video) {
		super();
		this.id = video.getId();
		this.titulo = video.getTitulo();
		this.descricao = video.getDescricao();
		this.url = video.getUrl();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public static Page<VideoDto> converter(Page<Video> videos) {

		return videos.map(VideoDto::new);
	}

}
