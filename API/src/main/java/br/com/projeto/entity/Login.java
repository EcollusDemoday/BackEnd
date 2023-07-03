package br.com.projeto.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "login")
public class Login {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_login")
	private Integer id;

	@Column(name = "usuario")
	private String usuario;

	@Column(name = "email")
	private String email;

	@Column(name = "senha")
	private String senha;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId_login() {
		return id;
	}

	public void setId_login(Integer id_login) {
		this.id = id_login;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Login() {
		   // Construtor vazio necessário para o JPA
		}
	
	public Login(Integer id_login, String usuario, String email, String senha) {
		super();
		this.id = id_login;
		this.usuario = usuario;
		this.email = email;
		this.senha = senha;
	}


}
