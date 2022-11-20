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
import com.Proyecto.parqueadero.fullstackbackend.Model.vehiculo;
import com.Proyecto.parqueadero.fullstackbackend.Repository.UsuarioRepository;
import com.Proyecto.parqueadero.fullstackbackend.Repository.VehiculoRepository;

@RestController
@RequestMapping("/api/vehiculos")
public class vehiculoController {

	@Autowired
	private VehiculoRepository vehiculoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping
	public ResponseEntity<Page<vehiculo>> ListarVehiculos(Pageable pageable) {

		return ResponseEntity.ok(vehiculoRepository.findAll(pageable));

	}

	@PostMapping
	public ResponseEntity<vehiculo> guardarvehiculo(@Validated @RequestBody vehiculo vehiculo) {
		Optional<usuario> usuarioOptional = usuarioRepository.findById(vehiculo.getUsuarios().getId());
		if (!usuarioOptional.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}
		vehiculo.setUsuarios(usuarioOptional.get());
		vehiculo vehiculoGuardado = vehiculoRepository.save(vehiculo);
		URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(vehiculoGuardado.getVehiculo_id()).toUri();
		return ResponseEntity.created(ubicacion).body(vehiculoGuardado);

	}

	@PutMapping("/{id}")
	public ResponseEntity<vehiculo> actualizarVehiculo(@PathVariable Integer id,
			@Validated @RequestBody vehiculo vehiculo) {
		Optional<usuario> usuarioOptional = usuarioRepository.findById(vehiculo.getUsuarios().getId());
		if (!usuarioOptional.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}

		Optional<vehiculo> vehiculoOptional = vehiculoRepository.findById(id);
		if (!vehiculoOptional.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}

		vehiculo.setUsuarios(usuarioOptional.get());
		vehiculo.setVehiculo_id(vehiculoOptional.get().getVehiculo_id());
		vehiculoRepository.save(vehiculo);

		return ResponseEntity.noContent().build();

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<vehiculo> eliminarVehiculo(@PathVariable Integer id) {
		Optional<vehiculo> vehiculoOptional = vehiculoRepository.findById(id);
		if (!vehiculoOptional.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}
		vehiculoRepository.delete(vehiculoOptional.get());
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<vehiculo>ObtenerVehiculoporId(@PathVariable Integer id){
		Optional<vehiculo> vehiculoOptional = vehiculoRepository.findById(id);
		if (!vehiculoOptional.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}
		
		return ResponseEntity.ok(vehiculoOptional.get());
		
		
	}

}
