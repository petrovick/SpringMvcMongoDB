package com.projeto.repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.projeto.business.RegistroEnergia;
import com.projeto.business.Usuario;


@Repository
//@Component
public interface RegistroEnergiaRepository extends MongoRepository<RegistroEnergia, String>{
	
	public List<RegistroEnergia> findByDataHora(String dataHora);
	public List<RegistroEnergia> findByUserEmail(String email);
	
}