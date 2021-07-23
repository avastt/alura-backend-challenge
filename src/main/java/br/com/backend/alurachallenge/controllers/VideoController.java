package br.com.backend.alurachallenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.backend.alurachallenge.controller.dto.VideoDto;
import br.com.backend.alurachallenge.entity.Video;
import br.com.backend.alurachallenge.repository.VideoRepository;

@RestController
@RequestMapping("/videos")
public class VideoController {

	@Autowired
	private VideoRepository videoRepository;
	
	@GetMapping
	public Page<VideoDto> lista(
			@PageableDefault(sort = "id", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {

		Page<Video> videos = videoRepository.findAll(paginacao);
		return VideoDto.converter(videos);
	}
}
