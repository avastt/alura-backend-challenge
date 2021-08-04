package br.com.backend.alurachallenge.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.backend.alurachallenge.entity.Video;

public interface VideoRepository extends JpaRepository<Video, Long>{

	@Query("SELECT DISTINCT v from Video v WHERE titulo = :titulo")
	Optional<Video> findByTitulo(String titulo); 


	
}
