package com.projeto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projeto.business.RegistroEnergia;
import com.projeto.business.Usuario;
import com.projeto.dto.RegistroEnergiaDTO;
import com.projeto.repository.RegistroEnergiaRepository;
import com.projeto.repository.UsuarioRepository;
import com.projeto.request.RegistroEnergiaRequest;
import com.spring.response.RegistroEnergiaResponse;

@Controller
@RequestMapping("/service/registroEnergia")
public class RegistroEnergiaController
{
	@Autowired
	private RegistroEnergiaRepository registroEnergiaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public @ResponseBody String helloWorld(ModelMap model) {
		
		return "teste";
	}
	
	@RequestMapping(value = "/registrar", 
			consumes="application/json",
			produces = "application/json",
			method = RequestMethod.POST)
	@ResponseBody
	public RegistroEnergiaResponse cadastrar(@RequestBody RegistroEnergiaRequest request)
	{
		RegistroEnergiaResponse response = new RegistroEnergiaResponse();
		try
		{
			Usuario user = usuarioRepository.findBytoken(request.getToken());//findByTokenEquals(request.getToken());
			if(user == null)
			{
				response.setMessage("Usuário não autenticado");
				response.setStatus(407);
				response.setToken(null);
				return response;
			}
			else
			{
				for(RegistroEnergiaDTO reDTO : request.getValores()){
					RegistroEnergia re  = new RegistroEnergia(null, reDTO.getDataHora(),
							reDTO.getKws(),
							reDTO.getCasa(),
							user);
					registroEnergiaRepository.save(re);
				}
			}
			response.setStatus(200);
			response.setMessage("Salvo com sucesso");
			List<RegistroEnergiaDTO> registrosDTO = new ArrayList<RegistroEnergiaDTO>();
			List<RegistroEnergia> registros = registroEnergiaRepository.findByUser(user);
			for(RegistroEnergia registro : registros){
				RegistroEnergiaDTO reDTO = new RegistroEnergiaDTO(
						registro.getId(),
						registro.getDataHora(),
						registro.getKws(),
						registro.getUser().getEmail(),
						registro.getCasa());
				registrosDTO.add(reDTO);
			}
			response.setRegistros(registrosDTO);
		} 
		catch(Exception ex)
		{
			response.setStatus(500);
			response.setMessage(ex.getMessage());
			response.setToken(null);
		}
		return response;
	}

}
