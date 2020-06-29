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
public class MovimentacaoController {
	
private final MovimentacaoRepository mr;
	
	@Autowired
	public MovimentacaoController(MovimentacaoRepository mr) {
		this.mr = mr;
	}
	
	
	@GetMapping("/movimentacao")	
	public ResponseEntity<?> listAll(){
		return new ResponseEntity<>(mr.findAll(), HttpStatus.OK);
		
	}
	
	@GetMapping("/movimentacao/{id}")
	public ResponseEntity<?> getUsuarioById(@PathVariable Long id) {
	    try {
	    	Movimentacao movimentacao = mr.findById(id).get();
	        return new ResponseEntity<Movimentacao>(movimentacao, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Movimentacao>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@PostMapping("/movimentacao/cadastrar")
	public ResponseEntity<?> save(@RequestBody Movimentacao movimentacao) {
	    return new ResponseEntity<>(mr.save(movimentacao), HttpStatus.OK );
	}
	
	@PutMapping("/movimentacao/editar")
	public ResponseEntity<?> update(@RequestBody Movimentacao movimentacao) {
	    try {
	    	mr.save(movimentacao);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@DeleteMapping("/movimentacao/deletar/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		mr.deleteById(id);
	    return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
