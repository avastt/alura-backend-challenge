package br.com.backend.alurachallenge.controller;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.backend.alurachallenge.controller.dto.VideoDto;
import br.com.backend.alurachallenge.controller.form.AtualizaVideoForm;
import br.com.backend.alurachallenge.controller.form.VideoForm;
import br.com.backend.alurachallenge.entity.Video;
import br.com.backend.alurachallenge.repository.VideoRepository;

@RestController
@RequestMapping("/videos")
public class VideoController {

	@Autowired
	private VideoRepository videoRepository;
	
	@GetMapping
	public Page<VideoDto> listaVideos (
			@PageableDefault(sort = "id", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {

		Page<Video> videos = videoRepository.findAll(paginacao);
		return VideoDto.converter(videos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<VideoDto> retornaVideo (@PathVariable Long id) {

		
		Optional<Video> video = videoRepository.findById(id);
		
		if(video.isPresent()) {
			

			return ResponseEntity.ok(new VideoDto(video.get()));
		} 
		
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<VideoDto> cadastrarVideo (@RequestBody VideoForm videoForm) {
		
		Video video = videoForm.converter();
		videoRepository.save(video);
		
		
		return new ResponseEntity<VideoDto>(new VideoDto(video), HttpStatus.CREATED);
	}
	
	@PutMapping("/atualiza/{id}")
	@Transactional
	public ResponseEntity<VideoDto> atualizarVideo (@PathVariable Long id, @RequestBody AtualizaVideoForm atualizaVideoForm) {
		
		Optional<Video> optional = videoRepository.findById(id);
		
		if(optional.isPresent()) {
			
			Video video = atualizaVideoForm.atualizar(id, videoRepository);
			videoRepository.save(video);
			
			return new ResponseEntity<VideoDto>(new VideoDto(video), HttpStatus.OK);
		}
		//return ResponseEntity.notFound().build();
		return new ResponseEntity<VideoDto>(new VideoDto(), HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/deletar/{id}")
	@Transactional
	public ResponseEntity<VideoDto> deletarVideo (@PathVariable Long id) {
		
		Optional<Video> optional = videoRepository.findById(id);
		
		if(optional.isPresent()) {
			videoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		//return ResponseEntity.notFound().build();
		return new ResponseEntity<VideoDto>(new VideoDto(), HttpStatus.NOT_FOUND);
	}
}
