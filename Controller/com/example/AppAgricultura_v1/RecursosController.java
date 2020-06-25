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
public class RecursosController {
	
	@Autowired
	private RecursosService service;
	
	
	@GetMapping("/recursos")	
	public List<Recursos> listaRecurso() {
        return service.listAll();
		
	}
	
	@GetMapping("/recursos/{codigo}")
	public ResponseEntity<Recursos> get(@PathVariable Integer codigo) {
	    try {
	    	Recursos recursos = service.get(codigo);
	        return new ResponseEntity<Recursos>(recursos, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Recursos>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@PostMapping("/recursos/cadastrar")
	public void add(@RequestBody Recursos recursos) {
	    service.save(recursos);
	}
	
	@PutMapping("/recursos/editar/{codigo}")
	public ResponseEntity<?> update(@RequestBody Recursos recursos, @PathVariable Integer codigo) {
	    try {
	    	Recursos existRecursos = service.get(codigo);
	       service.save(existRecursos);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@DeleteMapping("/recursos/deletar/{codigo}")
	public void delete(@PathVariable Integer codigo) {
	    service.delete(codigo);
	}
	
}
