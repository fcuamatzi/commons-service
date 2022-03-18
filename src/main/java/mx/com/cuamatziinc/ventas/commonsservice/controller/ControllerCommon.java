package mx.com.cuamatziinc.ventas.commonsservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import mx.com.cuamatziinc.ventas.commonsservice.service.IServiceCommon;


public class ControllerCommon<E, S extends IServiceCommon<E>> {

	@Autowired
	protected S serviceCommon;

	@GetMapping
	public ResponseEntity<?> findAll() {

		return ResponseEntity.ok().body(serviceCommon.findAll());

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {

		Optional<E> entityDb = serviceCommon.findById(id);

		if (entityDb.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {

			return ResponseEntity.ok(entityDb.get());
		}

	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody E entity) {

		E entityDb = serviceCommon.save(entity);

		return ResponseEntity.status(HttpStatus.CREATED).body(entityDb);

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		serviceCommon.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}

}
