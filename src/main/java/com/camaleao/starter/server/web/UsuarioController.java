package com.camaleao.starter.server.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.camaleao.starter.server.model.Usuario;
import com.camaleao.starter.server.services.UsuarioService;


@Controller
public class UsuarioController {

	private static final String BASE_URL = "/usuario";

	@Autowired
	private UsuarioService usuarioService;

	@ResponseBody
	@RequestMapping(value = BASE_URL + "/save", method = RequestMethod.POST)
	private Usuario save(@RequestBody Usuario usuario) {
		this.usuarioService.save(usuario);
		return usuario;
	}

}
