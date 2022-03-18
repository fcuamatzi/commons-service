package mx.com.cuamatziinc.ventas.commonsservice.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.cuamatziinc.ventas.commonsservice.service.IServiceCommon;
@Service
public class ServiceCommon<E, R extends CrudRepository<E, Long>> implements IServiceCommon<E>{
	
	@Autowired
	protected R repositoryEntity;

	@Override
	@Transactional(readOnly = true)
	public Iterable<E> findAll() {
		// TODO Auto-generated method stub
		return repositoryEntity.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<E> findById(Long id) {
		// TODO Auto-generated method stub
		return repositoryEntity.findById(id);
	}

	@Override
	@Transactional
	public E save(E product) {
		// TODO Auto-generated method stub
		return repositoryEntity.save(product);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		
		repositoryEntity.deleteById(id);
		
	}

}
