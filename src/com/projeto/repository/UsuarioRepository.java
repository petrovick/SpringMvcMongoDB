package com.projeto.repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.projeto.business.Usuario;


@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
	//@Query(value = "{ 'token' : ?0 }")
	public Usuario findBytoken(String token);
}
