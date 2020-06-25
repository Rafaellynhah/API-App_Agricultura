package com.example.AppAgricultura_v1;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	
	@GetMapping("/user")	
	public List<Usuario> listaRecurso() {
        return service.listAll();
		
	}
	
	
	
	@GetMapping("/user/{id}")
	public ResponseEntity<Usuario> get(@PathVariable Integer id) {
	    try {
	    	Usuario user = service.get(id);
	        return new ResponseEntity<Usuario>(user, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@PostMapping("/user/cadastrar")
	public void add(@RequestBody Usuario usuario) {
	    service.save(usuario);
	}
	
	@PutMapping("/user/editar/{id}")
	public ResponseEntity<?> update(@RequestBody Usuario user, @PathVariable Integer id) {
	    try {
	    	Usuario existUser = service.get(id);
	       service.save(user);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@DeleteMapping("/user/deletar/{id}")
	public void delete(@PathVariable Integer id) {
	    service.delete(id);
	}
	
}
