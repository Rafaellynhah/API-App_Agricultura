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
public class Tipo_RecursoController {
	
private final Tipo_RecursoRepository tr;
	
	@Autowired
	public Tipo_RecursoController(Tipo_RecursoRepository tr) {
		this.tr = tr;
	}
	
	
	@GetMapping("/tiporecurso")	
	public ResponseEntity<?> listAll(){
		return new ResponseEntity<>(tr.findAll(), HttpStatus.OK);
		
	}
	
	@GetMapping("/tiporecurso/{id}")
	public ResponseEntity<?> getUsuarioById(@PathVariable Long id) {
	    try {
	    	Tipo_Recurso tipo_recurso = tr.findById(id).get();
	        return new ResponseEntity<Tipo_Recurso>(tipo_recurso, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Tipo_Recurso>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@PostMapping("/tiporecurso/cadastrar")
	public ResponseEntity<?> save(@RequestBody Tipo_Recurso tipo_recurso) {
	    return new ResponseEntity<>(tr.save(tipo_recurso), HttpStatus.OK );
	}
	
	@PutMapping("/tiporecurso/editar")
	public ResponseEntity<?> update(@RequestBody Tipo_Recurso tipo_recurso) {
	    try {
	    	tr.save(tipo_recurso);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@DeleteMapping("/tiporecurso/deletar/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		tr.deleteById(id);
	    return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
