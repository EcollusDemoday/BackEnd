package br.com.projeto.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.projeto.entity.UsuarioEmpreendedor;
import br.com.projeto.repository.UsuarioEmpreendedorRepository;


@Service
public class UsuarioEmpreendedorService {
	private final UsuarioEmpreendedorRepository usuarioEmpreendedorRepository;

	@Autowired
	public UsuarioEmpreendedorService(UsuarioEmpreendedorRepository usuarioEmpreendedorRepository) {
		this.usuarioEmpreendedorRepository = usuarioEmpreendedorRepository;
	}

	public List<UsuarioEmpreendedor> getAllUsuarios() {
		return usuarioEmpreendedorRepository.findAll();
	}

	public UsuarioEmpreendedor getUsuarioById(Integer id_usuario) {
		return usuarioEmpreendedorRepository.findById(id_usuario).orElse(null);
	}

	public UsuarioEmpreendedor createUsuarioEmpreendedor(UsuarioEmpreendedor usuarioEmpreendedor) {
		return usuarioEmpreendedorRepository.save(usuarioEmpreendedor);
	}

	public UsuarioEmpreendedor updateUsuarioEmpreendedor(Integer id_usuario, UsuarioEmpreendedor usuarioEmpreendedor) {
		UsuarioEmpreendedor usuarioEmpreendedorExistente = usuarioEmpreendedorRepository.findById(id_usuario).orElse(null);
		if (usuarioEmpreendedorExistente != null) {
			usuarioEmpreendedor.setId(id_usuario);
			return usuarioEmpreendedorRepository.save(usuarioEmpreendedor);
		} else {
			return null;
		}
	}

	public boolean deleteUsuarioEmpreendedor(Integer id_usuario) {
		UsuarioEmpreendedor usuarioEmpreendedorExistente = usuarioEmpreendedorRepository.findById(id_usuario).orElse(null);
		if (usuarioEmpreendedorExistente != null) {
			usuarioEmpreendedorRepository.delete(usuarioEmpreendedorExistente);
			return true;
		} else {
			return false;
		}
	}
	public boolean verificarCnpjEmUso(String cnpj) {
	    UsuarioEmpreendedor usuarioEmpreendedor = usuarioEmpreendedorRepository.findByCnpj(cnpj);
	    return usuarioEmpreendedor != null;
	}
	public boolean verificarCredenciais(String cnpj, String senha) {
	    boolean cnpjEmUso = verificarCnpjEmUso(cnpj);
	    if (cnpjEmUso) {
	        UsuarioEmpreendedor usuarioEmpreendedor = usuarioEmpreendedorRepository.findByCnpj(cnpj);
	        if (usuarioEmpreendedor.getSenha().equals(senha)) {
	            return true;
	        }
	    }
	    return false;
	}
	
	
}
