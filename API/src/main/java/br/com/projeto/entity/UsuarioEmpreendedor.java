package br.com.projeto.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario_empreendedor")

public class UsuarioEmpreendedor {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
    private Integer id;
	
	@Column(name ="nome")
    private String nome;
	
	@Column(name ="cnpj")
    private String cnpj;
	
	@Column(name ="senha")
    private String senha;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public UsuarioEmpreendedor() {
		   // Construtor vazio necessário para o JPA
		}
		
	public UsuarioEmpreendedor(Integer id, String nome, String cnpj, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.senha = senha;
	}
	
}
