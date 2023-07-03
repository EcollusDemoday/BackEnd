package br.com.projeto.controller;

import java.util.List;
import java.util.Map;

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
import br.com.projeto.entity.UsuarioEmpreendedor;
import br.com.projeto.service.UsuarioEmpreendedorService;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/empreendedor")
public class UsuarioEmpreendedorController {
	private final UsuarioEmpreendedorService usuarioEmpreendedorService;

	@Autowired
	   public UsuarioEmpreendedorController(UsuarioEmpreendedorService usuarioEmpreendedorService) {
        this.usuarioEmpreendedorService = usuarioEmpreendedorService;
    }

	@GetMapping("/usersEmpreendedor")
	public List<UsuarioEmpreendedor> getAllUsuarios() {
		return usuarioEmpreendedorService.getAllUsuarios();
	}
	
	@GetMapping("/{id_usuario}")
    public ResponseEntity<UsuarioEmpreendedor> getUsuarioById(@PathVariable Integer id_usuario) {
    	UsuarioEmpreendedor usuarioEmpreendedor = usuarioEmpreendedorService.getUsuarioById(id_usuario);
        if (usuarioEmpreendedor != null) {
            return ResponseEntity.ok(usuarioEmpreendedor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para criar um novo usuário
    @PostMapping
    public ResponseEntity<UsuarioEmpreendedor> createUsuarioEmpreendedor(@RequestBody UsuarioEmpreendedor usuarioEmpreendedor) {
    	UsuarioEmpreendedor novoUsuarioEmpreendedor = usuarioEmpreendedorService.createUsuarioEmpreendedor(usuarioEmpreendedor);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuarioEmpreendedor);
    }
    
	@PostMapping("/verificar-cnpj")
	public ResponseEntity<?> verificarCnpj(@RequestBody Map<String, String> requestBody) {
	    String cnpj = requestBody.get("cnpj");
	    boolean cnpjEmUso = usuarioEmpreendedorService.verificarCnpjEmUso(cnpj);
	    if (cnpjEmUso) {
	        return ResponseEntity.status(HttpStatus.CONFLICT).body("Cnpj já está em uso.");
	    } else {
	        return ResponseEntity.ok().build();
	    }
	}
	
	@PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> requestBody) {
        String cnpj = requestBody.get("cnpj");
        String senha = requestBody.get("senha");

        boolean credenciaisValidas = usuarioEmpreendedorService.verificarCredenciais(cnpj, senha);

        if (credenciaisValidas) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas.");
        }
    }
    // Endpoint para atualizar um usuário existente
    @PutMapping("/{id_usuario}")
    public ResponseEntity<UsuarioEmpreendedor> updateUsuarioEmpreendedor(@PathVariable Integer id_usuario, @RequestBody UsuarioEmpreendedor usuarioEmpreendedor) {
    	UsuarioEmpreendedor usuarioAtualizadoEmpreendedor = usuarioEmpreendedorService.updateUsuarioEmpreendedor(id_usuario, usuarioEmpreendedor);
        if (usuarioAtualizadoEmpreendedor != null) {
            return ResponseEntity.ok(usuarioAtualizadoEmpreendedor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para excluir um usuário existente
    @DeleteMapping("/{id_usuario}")
    public ResponseEntity<UsuarioEmpreendedor> deleteUsuarioEmpreendedor(@PathVariable Integer id_usuario) {
        boolean removido = usuarioEmpreendedorService.deleteUsuarioEmpreendedor(id_usuario);
        if (removido) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }}