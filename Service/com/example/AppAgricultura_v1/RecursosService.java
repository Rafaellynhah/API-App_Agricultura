package com.example.AppAgricultura_v1;

import java.util.List;
 
import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 
@Service
@Transactional
public class RecursosService {

	    @Autowired
	    private RecursosRepository repo;
	     
	    public List<Recursos> listAll() {
	        return repo.findAll();
	    }
	     
	    public void save(Recursos recursos) {
	        repo.save(recursos);
	    }
	     
	    public Recursos get(Integer codigo) {
	        return repo.findById(codigo).get();
	    }
	     
	    public void delete(Integer codigo) {
	        repo.deleteById(codigo);
	    }
	

}
