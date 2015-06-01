package br.ufc.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.NoticiaDAO;
import br.ufc.dao.RoleDAO;
import br.ufc.dao.SecaoDAO;
import br.ufc.model.Noticia;
import br.ufc.model.Role;
import br.ufc.model.Secao;
import br.ufc.model.Usuario;

@Transactional
@Controller
public class NoticiaController {
	@Autowired
	NoticiaDAO noticiaDAO;
	@Autowired
	SecaoDAO secaoDAO;
	@RequestMapping("noticiaForm")
	public String formularioNoticia(Model model,HttpSession session){
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		Role role = (Role) session.getAttribute("role");
		if(usuario != null && (role.getRoleName().equals("Editor") || role.getRoleName().equals("Jornalista"))){
			model.addAttribute("secoes", secaoDAO.listarSecoes());
			return "noticia/noticia_form";
		}
		return "redirect:efetuarLogin";
	}
	@RequestMapping("cadastrarNoticia")
	public String cadastrarNoticia(Noticia noticia , Secao secao , HttpSession session){
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		Role role = (Role) session.getAttribute("role");
		if(usuario != null && (role.getRoleName().equals("Editor") || role.getRoleName().equals("Jornalista"))){
			System.out.println(noticia.getTexto());
			noticia.setAutor(usuario);
			System.out.println(secao.getIdSecao());
			noticia.setSecao(secaoDAO.getSecao(secao.getIdSecao()));
			noticia.setDataNoticia(new Date());
			noticiaDAO.adicionarNoticia(noticia);
			return "noticia/sucesso";
		}
		return "redirect:../../index";
	}
	@RequestMapping("listarNoticias")
	public String listarNoticias(Model model){
		model.addAttribute("noticias", noticiaDAO.listarNoticia());
		return "noticia/listar";
	}
}
