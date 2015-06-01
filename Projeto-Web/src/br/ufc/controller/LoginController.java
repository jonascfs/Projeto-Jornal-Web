package br.ufc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.RoleDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Role;
import br.ufc.model.Usuario;

@Controller
public class LoginController {
	@Autowired
	UsuarioDAO usuarioDAO;
	@Autowired
	RoleDAO roleDAO;
	@RequestMapping("loginForm")
	public String loginForm(Model model){
		List<Role> roles = roleDAO.getRoles();
		model.addAttribute("roles", roles);
		return "formulario_login";
	}
	@RequestMapping("efetuarLogin")
	public String efetuarLogin(Usuario usuario,Role role, HttpSession session){
		String senha = usuario.getSenha();
		usuario = usuarioDAO.getUsuario(usuario.getLogin());
		role = roleDAO.getRole(role.getIdRole());
		if(usuario != null && usuario.getSenha().equals(senha) && usuario.is(role.getRoleName())){
			session.setAttribute("usuario", usuario);
			session.setAttribute("role", role);
			return "../../index";
		}else
			return "redirect:loginForm";
	}
	
}
