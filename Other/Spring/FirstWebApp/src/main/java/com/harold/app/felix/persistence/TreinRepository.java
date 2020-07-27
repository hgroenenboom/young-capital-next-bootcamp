package com.harold.app.felix.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.harold.app.felix.domain.Trein;

@Component
public interface TreinRepository extends CrudRepository <Trein, Long>{

}
