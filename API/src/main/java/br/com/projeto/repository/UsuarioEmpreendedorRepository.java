package br.com.projeto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.entity.UsuarioEmpreendedor;

public interface UsuarioEmpreendedorRepository extends JpaRepository<UsuarioEmpreendedor, Integer> {
	Optional<UsuarioEmpreendedor> findById(Integer id_usuario);
	UsuarioEmpreendedor findByCnpj(String cnpj);

}
