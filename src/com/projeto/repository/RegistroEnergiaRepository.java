package com.projeto.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.projeto.business.RegistroEnergia;
import com.projeto.business.Users;


@Repository
//@Component
public interface RegistroEnergiaRepository extends MongoRepository<RegistroEnergia, String>{

}