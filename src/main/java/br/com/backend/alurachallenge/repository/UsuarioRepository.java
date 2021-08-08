package br.com.backend.alurachallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.backend.alurachallenge.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Usuario findByUsuarioNome(String nome);
}
