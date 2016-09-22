package com.projeto.repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.projeto.business.Casa;
import com.projeto.business.Usuario;


@Repository
public interface CasaRepository extends MongoRepository<Casa, String> {
	
}
