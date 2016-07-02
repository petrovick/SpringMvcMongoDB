package com.projeto.controller;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projeto.business.RegistroEnergia;
import com.projeto.repository.RegistroEnergiaRepository;
//import com.projeto.repository.UserRepository;

@Controller
@RequestMapping("/")
public class HomeController {

//	@Autowired
//	private UserRepository usersRepository;
	
	@Autowired
	private RegistroEnergiaRepository registroEnergiaRepository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String helloWorld(@RequestParam String email, ModelMap model) throws JsonGenerationException, JsonMappingException, IOException {
		List<RegistroEnergia> energias = registroEnergiaRepository.findByUserEmail(email);
		
		final StringWriter sw =new StringWriter();
	    final ObjectMapper mapper = new ObjectMapper();
	    mapper.writeValue(sw, energias);
	    
		model.addAttribute("registros", sw.toString());
		return "/private/index";
	}


	@RequestMapping(value = "/helloagain", method = RequestMethod.GET)
	public String sayHelloAgain(ModelMap model) {
		model.addAttribute("greeting", "Hello World Again, from Spring 4 MVC");
		return "welcome";
	}

}