package com.example.AppAgricultura_v1;

import java.util.NoSuchElementException;
import java.util.Set;

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
	
private final RecursoRepository rr;
	
	@Autowired
	public RecursosController(RecursoRepository rr) {
		this.rr = rr;
	}
	
	
	@GetMapping("/recursos")	
	public ResponseEntity<?> listAll(){
		return new ResponseEntity<>(rr.findAll(), HttpStatus.OK);
		
	}
	
	@GetMapping("/recursos/{id}")
	public ResponseEntity<?> getUsuarioById(@PathVariable Long id) {
	    try {
	    	Recurso rec = rr.findById(id).get();
	        return new ResponseEntity<Recurso>(rec, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Recurso>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@PostMapping("/recursos/cadastrar")
	public ResponseEntity<?> save(@RequestBody Recurso rec) {
	    return new ResponseEntity<>(rr.save(rec), HttpStatus.OK );	
		
	}

	
	@PutMapping("/recursos/editar")
	public ResponseEntity<?> update(@RequestBody Recurso rec) {
	    try {
	    	rr.save(rec);
	    	CalcularProdutividade(rec);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@DeleteMapping("/recursos/deletar/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
	    rr.deleteById(id);
	    return new ResponseEntity<>(HttpStatus.OK);
	}
		
	
	//Calculos
	public void CalcularProdutividade(Recurso rec) {
	
		Recurso recurso = rr.findById(rec.getId()).get();
		float qtd_final = recurso.getQtd_final();
		float pd_esperada = recurso.getProdutividade_esperada();
		float produtividade = 0;
		float percentual_produtividade = 0;
		
		produtividade = pd_esperada-qtd_final;
		percentual_produtividade = ((pd_esperada+qtd_final)*produtividade)/100;
		recurso.setProdutividade(percentual_produtividade);
		rr.save(recurso);
			
		
	}
	
	
	
}
