package com.example.AppAgricultura_v1;

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
	private final UsuarioRepository up;
	
	@Autowired
	public UsuarioController(UsuarioRepository up) {
		this.up = up;
	}
	
	
	@GetMapping("/user")	
	public ResponseEntity<?> listAll(){
		return new ResponseEntity<>(up.findAll(), HttpStatus.OK);
		
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<?> getUsuarioById(@PathVariable Long id) {
	    try {
	    	Usuario user = up.findById(id).get();
	        return new ResponseEntity<Usuario>(user, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@PostMapping("/user/cadastrar")
	public ResponseEntity<?> save(@RequestBody Usuario usuario) {
	    return new ResponseEntity<>(up.save(usuario), HttpStatus.OK );
	}
	
	@PutMapping("/user/editar")
	public ResponseEntity<?> update(@RequestBody Usuario user) {
	    try {
	    	up.save(user);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@DeleteMapping("/user/deletar/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
	    up.deleteById(id);
	    return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
