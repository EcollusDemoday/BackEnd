package br.com.projeto.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name = "usuario")

public class Usuario {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
    private Integer id;
	
	@Column(name ="nome")
    private String nome; 
	
	@Column(name ="email")
    private String email;
	
	
	@Column(name ="senha")
    private String senha;
	
	

	public Integer getId_usuario() {
		return id;
	}

	public void setId_usuario(Integer id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getSenha() {
		return senha;
	}


	
	public Usuario() {
		   // Construtor vazio necessário para o JPA
		}
		
	public Usuario(Integer id,String email, String nome, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		
		
	}
    

}
