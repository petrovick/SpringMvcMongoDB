package com.projeto.controller;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projeto.business.Cliente;
import com.projeto.business.RegistroEnergia;
import com.projeto.business.Usuario;
import com.projeto.repository.UsuarioRepository;
import com.projeto.request.LoginRequest;
import com.spring.response.LoginResponse;

@RequestMapping("/service/login")
@Controller
public class LoginController
{
	@Autowired
	private UsuarioRepository usuarioRepository;
	
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
			Usuario usuario = usuarioRepository.findBytoken(request.getEmail());
			if(usuario == null)
			{
				usuario = new Usuario(request.getEmail(), request.getSenha(), token);
				usuario = usuarioRepository.save(usuario);
				if(usuario == null)
				{
					throw new Exception("Erro ao salvar usuário.");
				}
				else
				{
					response.setStatus(200);
					response.setToken(token);
					response.setMessage("Salvo com sucesso.");
					response.setEmail(request.getEmail());
				}
			}
			else if(usuario.getPassword().equals(request.getSenha()))
			{
				response.setStatus(200);
				response.setToken(token);
				response.setMessage("Salvo com sucesso.");
				response.setEmail(request.getEmail());
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
}
