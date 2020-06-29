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
public class GastoController {
	
private final GastoRepository gr;
	
	@Autowired
	public GastoController(GastoRepository gr) {
		this.gr = gr;
	}
	
	
	@GetMapping("/gasto")	
	public ResponseEntity<?> listAll(){
		return new ResponseEntity<>(gr.findAll(), HttpStatus.OK);
		
	}
	
	@GetMapping("/gasto/{id}")
	public ResponseEntity<?> getUsuarioById(@PathVariable Long id) {
	    try {
	    	Gasto gasto = gr.findById(id).get();
	        return new ResponseEntity<Gasto>(gasto, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Gasto>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@PostMapping("/gasto/cadastrar")
	public ResponseEntity<?> save(@RequestBody Gasto gasto) {
	    return new ResponseEntity<>(gr.save(gasto), HttpStatus.OK );
	}
	
	@PutMapping("/gasto/editar")
	public ResponseEntity<?> update(@RequestBody Gasto gasto) {
	    try {
	    	gr.save(gasto);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@DeleteMapping("/gasto/deletar/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		gr.deleteById(id);
	    return new ResponseEntity<>(HttpStatus.OK);
	}
	
	//Calculo
	public void CalcularMediaGastos() {
		
	}
	
	
}
