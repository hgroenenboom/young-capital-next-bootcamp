package com.harold.app.tests.dataBaseTest.persistance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.harold.app.tests.dataBaseTest.domain.UserEntity;
import com.harold.app.tests.dataBaseTest.persistance.UserRepository;


@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository treinRepository;

	public UserEntity save(UserEntity trein){
		return treinRepository.save(trein);
	}
	
	public UserEntity findById(Integer id) {
		return treinRepository.findById(id).get();
	}

	public Iterable <UserEntity> findAll(){
		Iterable <UserEntity> result = treinRepository.findAll();
		return result;
	}
}
