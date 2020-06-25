package com.example.AppAgricultura_v1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecursosRepository extends JpaRepository<Recursos, Integer> {

}
