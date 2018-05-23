package br.com.antonio.qcrapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.antonio.qcrapi.entity.UsuarioEntity;


@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
	
	public UsuarioEntity findByToken(String token);
	
	public UsuarioEntity findByEmail(String email);
}