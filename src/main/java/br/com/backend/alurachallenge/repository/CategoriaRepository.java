package br.com.backend.alurachallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.backend.alurachallenge.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	
}
