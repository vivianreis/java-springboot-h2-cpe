package com.cpe.consulta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cpe.consulta.model.Consulta;
	
	@Repository
	public interface ConsultaRepository extends JpaRepository<Consulta, Integer>{
		
	}


