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
public class Tipo_GastoController {
	
private final Tipo_GastoRepository tr;
	
	@Autowired
	public Tipo_GastoController(Tipo_GastoRepository tr) {
		this.tr = tr;
	}
	
	
	@GetMapping("/tipogasto")	
	public ResponseEntity<?> listAll(){
		return new ResponseEntity<>(tr.findAll(), HttpStatus.OK);
		
	}
	
	@GetMapping("/tipogasto/{id}")
	public ResponseEntity<?> getUsuarioById(@PathVariable Long id) {
	    try {
	    	Tipo_Gasto tipo_gasto = tr.findById(id).get();
	        return new ResponseEntity<Tipo_Gasto>(tipo_gasto, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Tipo_Gasto>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@PostMapping("/tipogasto/cadastrar")
	public ResponseEntity<?> save(@RequestBody Tipo_Gasto tipo_gasto) {
	    return new ResponseEntity<>(tr.save(tipo_gasto), HttpStatus.OK );
	}
	
	@PutMapping("/tipogasto/editar")
	public ResponseEntity<?> update(@RequestBody Tipo_Gasto tipo_gasto) {
	    try {
	    	tr.save(tipo_gasto);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@DeleteMapping("/tipogasto/deletar/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		tr.deleteById(id);
	    return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
