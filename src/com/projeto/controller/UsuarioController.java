package com.projeto.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projeto.business.Casa;
import com.projeto.business.Cliente;
import com.projeto.business.RegistroEnergia;
import com.projeto.business.Usuario;
import com.projeto.repository.UsuarioRepository;
import com.projeto.request.LoginRequest;
import com.projeto.request.UsuarioRequest;
import com.spring.response.LoginResponse;
import com.spring.response.UsuarioResponse;

@RequestMapping("/service/usuario")
@Controller
public class UsuarioController
{
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public @ResponseBody String helloWorld(ModelMap model) {
		
		return "teste";
	}
	
	@RequestMapping(value = "/cadastrarCasa", 
			consumes="application/json",
			produces = "application/json",
			method = RequestMethod.POST)
	@ResponseBody
	public UsuarioResponse cadastrarCasa(@RequestBody UsuarioRequest request)
	{
		UsuarioResponse response = new UsuarioResponse();
		try
		{
			Usuario usuario = usuarioRepository.findBytoken(request.getUsuario().getToken());
			if(usuario == null)
			{
				response.setStatus(407);
				response.setMessage("Usuário não autenticado.");
				return response;
			}
			List<Casa> casas = usuario.getCasas();
			if(casas == null)
				casas = new ArrayList<Casa>();
			casas.addAll(request.getUsuario().getCasas());
			usuario.setCasas(casas);
			usuario = usuarioRepository.save(usuario);
			if(usuario == null)
			{
				throw new Exception("Erro ao salvar usuário!");
			}
			response.setMessage("Salvo com sucesso!");
			response.setStatus(200);
			response.setUsuario(usuario);
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
