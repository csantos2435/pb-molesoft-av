package com.pb_molesoft_av03.estados_brasileiros.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.pb_molesoft_av03.estados_brasileiros.controller.dto.DadosEspecificosUsuarioDto;
import com.pb_molesoft_av03.estados_brasileiros.controller.dto.UsuarioDto;
import com.pb_molesoft_av03.estados_brasileiros.controller.form.PutUsuarioForm;
import com.pb_molesoft_av03.estados_brasileiros.controller.form.UsuarioForm;
import com.pb_molesoft_av03.estados_brasileiros.modelo.Usuario;
import com.pb_molesoft_av03.estados_brasileiros.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuariosController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<UsuarioDto> post(@RequestBody @Valid UsuarioForm form, UriComponentsBuilder uriBuilder){
		Usuario usuario = form.converter();
		usuarioRepository.save(usuario);
		
		URI uri = uriBuilder.path("/api/v1/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(new UsuarioDto(usuario));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<DadosEspecificosUsuarioDto> put(@PathVariable long id, @RequestBody @Valid PutUsuarioForm form){
		Usuario usuario = form.put(id, usuarioRepository);
		
		return ResponseEntity.ok(new DadosEspecificosUsuarioDto(usuario));
	}
	
	@GetMapping
	public List<UsuarioDto> get(String nomeUsuario){
		if(nomeUsuario == null) {
			List<Usuario> usuario = usuarioRepository.findAll(); 
			return UsuarioDto.converter(usuario);
		}else {
			List<Usuario> usuario = usuarioRepository.findByNome(nomeUsuario); 
			return UsuarioDto.converter(usuario);
		}
	}
	
}
