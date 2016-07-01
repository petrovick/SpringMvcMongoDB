package com.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.business.Cliente;
import com.projeto.business.RegistroEnergia;
import com.projeto.business.Users;
import com.projeto.repository.RegistroEnergiaRepository;
import com.projeto.repository.UsersRepository;

@Controller
@RequestMapping("/")
public class HelloWorldController {

	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private RegistroEnergiaRepository registroEnergiaRepository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody String helloWorld(ModelMap model) {
		RegistroEnergia re = new RegistroEnergia(null, 1000f, 
				new Cliente("petrovickg@hotmail.com",
						"petrovick", "senha"));
		
		registroEnergiaRepository.save(re);
		
		return "teste";
	}

//	@RequestMapping(method = RequestMethod.GET)
//	public String sayHello(ModelMap model) {
//
//		model.addAttribute("greeting", "Hello World from Spring 4 MVC");
//		return "welcome";
//	}

	@RequestMapping(value = "/helloagain", method = RequestMethod.GET)
	public String sayHelloAgain(ModelMap model) {
		model.addAttribute("greeting", "Hello World Again, from Spring 4 MVC");
		return "welcome";
	}

}