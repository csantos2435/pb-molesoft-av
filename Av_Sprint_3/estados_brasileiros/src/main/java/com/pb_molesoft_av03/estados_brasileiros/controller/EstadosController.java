package com.pb_molesoft_av03.estados_brasileiros.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.pb_molesoft_av03.estados_brasileiros.controller.dto.EstadoDto;
import com.pb_molesoft_av03.estados_brasileiros.controller.form.EstadoForm;
import com.pb_molesoft_av03.estados_brasileiros.modelo.Estado;
import com.pb_molesoft_av03.estados_brasileiros.repository.EstadoRepository;

@RestController
@RequestMapping("/api/v1/estados")
public class EstadosController {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<EstadoDto> post(@RequestBody @Valid EstadoForm form, UriComponentsBuilder uriBuilder){
		Estado estado = form.converter();
		estadoRepository.save(estado);
		
		URI uri = uriBuilder.path("/api/v1/estados/{id}").buildAndExpand(estado.getId()).toUri();
		return ResponseEntity.created(uri).body(new EstadoDto(estado));
	}
	
	@GetMapping
	public List<EstadoDto> get(String nomeRegiao){
		if(nomeRegiao == null) {
			List<Estado> estado = estadoRepository.findAll(); 
			return EstadoDto.converter(estado);
		}else {
			List<Estado> estado = estadoRepository.findByRegiao(nomeRegiao); 
			return EstadoDto.converter(estado);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EstadoDto> getId(@PathVariable long id) {
		Optional<Estado> estado = estadoRepository.findById(id);
		if(estado.isPresent()) {
			return ResponseEntity.ok(new EstadoDto(estado.get()));
		}
		return ResponseEntity.notFound().build();		
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<EstadoDto> put(@PathVariable long id, @RequestBody @Valid EstadoForm form){
		Estado estado = form.put(id, estadoRepository);
		
		return ResponseEntity.ok(new EstadoDto(estado));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> delete(@PathVariable long id){
		estadoRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
