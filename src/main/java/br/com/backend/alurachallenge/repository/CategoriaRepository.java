package br.com.backend.alurachallenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.backend.alurachallenge.entity.Categoria;
import br.com.backend.alurachallenge.entity.Video;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	@Query("SELECT v FROM Video v " + "JOIN FETCH  v.categoria " + "WHERE v.categoria.id = :id")
	List<Video> getVideosById(@Param("id") Long id);

}
 