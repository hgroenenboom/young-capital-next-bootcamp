package com.harold.app.felix.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.harold.app.felix.domain.Trein;



@Service
@Transactional
public class TreinService {
	
	@Autowired
	private TreinRepository treinRepository;

	public Trein save(Trein trein){
		return treinRepository.save(trein);
	}
	
	public Trein findById(Long id) {
		return treinRepository.findById(id).get();
	}

	public Iterable <Trein> findAll(){
		Iterable <Trein> result = treinRepository.findAll();
		return result;
	}
}
