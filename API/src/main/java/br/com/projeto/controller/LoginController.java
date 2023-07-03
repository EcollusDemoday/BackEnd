package br.com.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.entity.Login;
import br.com.projeto.service.LoginService;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/login") // Rota base para todas as solicitações relacionadas a usuários
public class LoginController {
    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

        // Endpoint para recuperar todos os usuários
    @GetMapping("/loginUsers")
    public List <Login> getAllLogin() {
        return loginService.getAllLogins();
    }

    // Endpoint para recuperar um usuário por ID
    @GetMapping("/{id_login}")
    public ResponseEntity<Login> getUsuarioById(@PathVariable("id_login") Integer id_login) {
    	Login login = loginService.getLoginById(id_login);
        if (login != null) {
            return ResponseEntity.ok(login);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para criar um novo usuário
    @PostMapping
    public ResponseEntity<Login> createLogin(@RequestBody Login login) {
    	Login novoLogin = loginService.createLogin(login);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoLogin);
    }


    @PutMapping("/{id_login}")
    public ResponseEntity<Login> updateLogin(@PathVariable("id_login") Integer id_login, @RequestBody Login login) {
        Login loginExistente = loginService.getLoginById(id_login);

        if (loginExistente != null) {
            loginExistente.setUsuario(login.getUsuario());
            loginExistente.setSenha(login.getSenha());
            loginExistente.setEmail(login.getEmail());

            Login loginAtualizado = loginService.updateLogin(id_login, loginExistente);
            return ResponseEntity.ok(loginAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para excluir um usuário existente
    @DeleteMapping("/{id_login}")
    public ResponseEntity<Void> deleteLogin(@PathVariable("id_login") Integer id_login) {
        boolean removido = loginService.deleteLogin(id_login);
        if (removido) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

// Endpoint para atualizar um usuário existente
//@PutMapping("/login/{id_login}")
//public ResponseEntity<Login> updateLogin(@PathVariable("id_login") Integer id_login, @RequestBody Login login) {
//	Login loginAtualizado = loginService.updateLogin(id_login, login);
//  if (loginAtualizado != null) {
//      return ResponseEntity.ok(loginAtualizado);
//  } else {
//      return ResponseEntity.notFound().build();
//  }
//}

