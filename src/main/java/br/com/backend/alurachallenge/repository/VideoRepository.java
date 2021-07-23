package br.com.backend.alurachallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.backend.alurachallenge.entity.Video;

public interface VideoRepository extends JpaRepository<Video, Long>{

	
}
