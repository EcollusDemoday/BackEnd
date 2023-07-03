package br.com.projeto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {
    Optional<Login> findById(Integer id_login);
    
    Optional<Login> getLoginByEmail(String email);
}