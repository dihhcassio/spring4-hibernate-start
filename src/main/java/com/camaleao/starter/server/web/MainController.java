package com.camaleao.starter.server.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.camaleao.starter.server.services.UsuarioService;

@Controller
public class MainController {
	
	@Autowired
	private UsuarioService usuarioService;

	// private Logger log = Logger.getLogger(getClass());
	@RequestMapping(value = "/", method = RequestMethod.GET)
	private String main(ModelMap model) {
		int countUsuario = usuarioService.getCountUsuarios();
		model.addAttribute("countUsuarios", countUsuario);
		return "main";
	}
	
}