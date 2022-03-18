package mx.com.cuamatziinc.ventas.commonsservice.service;

import java.util.Optional;

public interface IServiceCommon<E> {
	
	
	Iterable<E> findAll();
	
	Optional<E> findById(Long id);
	
	E save(E entity);
	
	void deleteById(Long id);

}
