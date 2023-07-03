package br.com.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.entity.Login;
import br.com.projeto.repository.LoginRepository;

@Service
public class LoginService {
	private final LoginRepository loginRepository;

	@Autowired
	public LoginService(LoginRepository loginRepository) {
		this.loginRepository = loginRepository;
	}

	public List<Login> getAllLogins() {
		return loginRepository.findAll();
	}

	public Login getLoginById(Integer id_login) {
		return loginRepository.findById(id_login).orElse(null);
	}

	public Login createLogin(Login login) {
		return loginRepository.save(login);
	}

	public Login updateLogin(Integer id_login, Login login) {
		Login loginExistente = loginRepository.findById(id_login).orElse(null);
		if (loginExistente != null) {
			login.setId_login(id_login);
			return loginRepository.save(login);
		} else {
			return null;
		}
	}

	public boolean deleteLogin(Integer id_login) {
		Login loginExistente = loginRepository.findById(id_login).orElse(null);
		if (loginExistente != null) {
			loginRepository.delete(loginExistente);
			return true;
		} else {
			return false;
		}
	}
	
  
}
