package com.cpe.consulta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpe.consulta.model.Consulta;
import com.cpe.consulta.repository.ConsultaRepository;

@RestController
@RequestMapping(path = "/consultas")
public class ConsultaController {
	
	@Autowired
	private ConsultaRepository repository;
	
	@GetMapping
	public Iterable<Consulta> list(){
		return repository.findAll();
	}
	
	@PostMapping
	public Consulta save(@RequestBody Consulta consulta) {
		return repository.save(consulta);
	}
	
	@PutMapping(path = "{id}")
	Consulta replaceConsulta(@RequestBody Consulta newConsulta, @PathVariable Integer id) {
		return repository.findById(id)
		.map(consulta -> {
			consulta.setNomePaciente(newConsulta.getNomePaciente());
			consulta.setNomeMedico(newConsulta.getNomeMedico());
			consulta.setExame(newConsulta.getExame());
			consulta.setData(newConsulta.getExame());
			consulta.setHorario(newConsulta.getHorario());
			return repository.save(consulta);
		})	
		.orElseGet(() -> {
			newConsulta.setId(id);
			return repository.save(newConsulta);
		});
	}
	
		
	@DeleteMapping(path = "{id}")
	void deleteConsulta(@PathVariable Integer id) {
		repository.deleteById(id);
	}	
}
