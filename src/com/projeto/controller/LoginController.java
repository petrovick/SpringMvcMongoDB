package com.projeto.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projeto.business.Casa;
import com.projeto.business.Usuario;
import com.projeto.repository.CasaRepository;
import com.projeto.repository.UsuarioRepository;
import com.projeto.request.LoginRequest;
import com.spring.response.LoginResponse;

@RequestMapping("/service/login")
@Controller
public class LoginController
{
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private CasaRepository casaRepository;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public @ResponseBody String helloWorld(ModelMap model) {
		
		return "teste";
	}
	
	@RequestMapping(value = "/cadastrar", 
			consumes="application/json",
			produces = "application/json",
			method = RequestMethod.POST)
	@ResponseBody
	public LoginResponse cadastrar(@RequestBody LoginRequest request)
	{
		LoginResponse response = new LoginResponse();
		try
		{
			String token = Double.toString(new Date().getTime() / 10.0 * 44.0);
			Usuario usuario = usuarioRepository.findByemail(request.getUsuario().getEmail());
			if(usuario == null)
			{
				usuario = request.getUsuario();
				List<Casa> casas = buscarCasas(usuario, request);
				usuario.setCasas(casas);
				usuario.setToken(token);
				usuario = usuarioRepository.save(usuario);
				response.setStatus(200);
				response.setToken(token);
				
				response.setMessage("Salvo com sucesso.");
				response.setUsuario(usuario);
			}
			else if(usuario.getPassword().equals(request.getUsuario().getPassword()))
			{
				List<Casa> casas = buscarCasas(usuario, request);
				usuario.setCasas(casas);
				usuario.setToken(token);
				usuario = usuarioRepository.save(usuario);
				response.setStatus(200);
				response.setToken(token);
				response.setMessage("Salvo com sucesso."); 
				response.setUsuario(usuario);
			}
			else
			{
				throw new Exception("Usuário ou senha incorretos.");
			}
		}
		catch(Exception ex)
		{
			response.setStatus(500);
			response.setMessage(ex.getMessage());
			response.setToken(null);
		}
		return response;
	}
	
	private List<Casa> buscarCasas(Usuario usuario, LoginRequest request)
	{
		List<Casa> casas = new ArrayList<Casa>();
		if(usuario.getCasas() == null)
		{
			usuario.setCasas(casas);
			casas.addAll(request.getUsuario().getCasas());
		}
		else
		{
			boolean existeCasaIgual = false;
			for(Casa casa : usuario.getCasas())
			{
				if(casa.getLogradouro()
						.equalsIgnoreCase(request.getUsuario().getCasas().get(0).getLogradouro())
					&&
					casa.getNumero().equalsIgnoreCase(request.getUsuario().getCasas().get(0).getNumero()))
				{
					existeCasaIgual = true;
				}
			}
			if(!existeCasaIgual)
			{
				casas.add(request.getUsuario().getCasas().get(0));
			}
			if(usuario.getCasas() != null)
				casas.addAll(usuario.getCasas());
		}
		casas = casaRepository.save(casas);
		return casas;
	}
}
