package br.ufc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.SecaoDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Role;
import br.ufc.model.Secao;
import br.ufc.model.Usuario;
@Transactional
@Controller
public class UsuarioController {
	@Autowired
	private UsuarioDAO userDAO;
	@Autowired
	private SecaoDAO secaoDAO;
	
	@RequestMapping("usuarioForm")
	public String usuarioForm(){
		return "/usuario/usuario_form";
	}
	@RequestMapping("cadastrarUsuario")
	public String cadastrarUsuario(Usuario usuario){
		if(userDAO.getUsuario(usuario.getLogin() ) == null){
			userDAO.adicionarUsuario(usuario);
			return "../../index";
		}else
			return "redirect:efetuarLogin";
	}
	@RequestMapping("secaoForm")
	public String secaoForm(HttpSession session){
		Role role = (Role) session.getAttribute("role");
		if(role != null && role.getRoleName().equals("Editor") )
			return "usuario/secao_form";
		else
			return "redirect:efetuarLogin";
	}
	@RequestMapping("cadastrarSecao")
	public String cadastrarSecao(Secao secao, HttpSession session){
		if(session != null){
			System.out.println("session != null");
			Role role = (Role)session.getAttribute("role");
			if(role.getRoleName().equals("Editor")){
				secaoDAO.adicionarSecao(secao);
				return "../../index";
			}
		}
		return "redirect:efetuarLogin";
	}
	
}
