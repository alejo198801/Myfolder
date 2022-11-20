package com.Proyecto.parqueadero.fullstackbackend.Controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.Proyecto.parqueadero.fullstackbackend.Model.usuario;
import com.Proyecto.parqueadero.fullstackbackend.Repository.UsuarioRepository;

@RestController
@RequestMapping("/api/usuario")
public class usuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public ResponseEntity<Page<usuario>>listarusuarios(Pageable pageable){
		return ResponseEntity.ok(usuarioRepository.findAll(pageable));
		
		
	}

	@PostMapping
	public ResponseEntity<usuario> guardarusuario(@Validated @RequestBody usuario usuario) {
		usuario usuarioguardado = usuarioRepository.save(usuario);
		URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(usuarioguardado.getId()).toUri();
		return ResponseEntity.created(ubicacion).body(usuarioguardado);
	}

	@PutMapping("/{id}")
	public ResponseEntity<usuario> actualizarusuario(@PathVariable Integer id,
			@Validated @RequestBody usuario usuario) {
		Optional<usuario> usuarioOptional = usuarioRepository.findById(id);
		if (!usuarioOptional.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}
		usuario.setId(usuarioOptional.get().getId());
		usuarioRepository.save(usuario);
		return ResponseEntity.noContent().build();

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<usuario> eliminarusuario(@PathVariable Integer id) {
		Optional<usuario> usuarioOptional = usuarioRepository.findById(id);
		if (!usuarioOptional.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}
		usuarioRepository.delete(usuarioOptional.get());
		return ResponseEntity.noContent().build();

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<usuario>obtenerUsuarioporId(@PathVariable Integer id){
		Optional<usuario> usuarioOptional = usuarioRepository.findById(id);
		if (!usuarioOptional.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}
		return ResponseEntity.ok(usuarioOptional.get());
		
	}	
	

}
