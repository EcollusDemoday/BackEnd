package br.com.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.entity.Usuario;
import br.com.projeto.repository.UsuarioRepository;

@Service
public class UsuarioService {
	private final UsuarioRepository usuarioRepository;

	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public List<Usuario> getAllUsuarios() {
		return usuarioRepository.findAll();
	}

	public Usuario getUsuarioById(Integer id_usuario) {
		return usuarioRepository.findById(id_usuario).orElse(null);
	}

	public Usuario createUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public Usuario updateUsuario(Integer id_usuario, Usuario usuario) {
		Usuario usuarioExistente = usuarioRepository.findById(id_usuario).orElse(null);
		if (usuarioExistente != null) {
			usuario.setId_usuario(id_usuario);
			return usuarioRepository.save(usuario);
		} else {
			return null;
		}
	}

	public boolean deleteUsuario(Integer id_usuario) {
		Usuario usuarioExistente = usuarioRepository.findById(id_usuario).orElse(null);
		if (usuarioExistente != null) {
			usuarioRepository.delete(usuarioExistente);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean verificarEmailEmUso(String email) {
	    Usuario usuario = usuarioRepository.findByEmail(email);
	    return usuario != null;
	}
	
	public boolean verificarCredenciais(String email, String senha) {
	    boolean emailEmUso = verificarEmailEmUso(email);
	    if (emailEmUso) {
	        Usuario usuario = usuarioRepository.findByEmail(email);
	        if (usuario.getSenha().equals(senha)) {
	            return true;
	        }
	    }
	    return false;
	}

}
