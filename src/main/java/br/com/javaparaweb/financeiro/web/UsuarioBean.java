package br.com.javaparaweb.financeiro.web;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.javaparaweb.financeiro.usuario.Usuario;
import br.com.javaparaweb.financeiro.usuario.UsuarioRN;


@ManagedBean
@RequestScoped
public class UsuarioBean {
	private Usuario usuario = new Usuario();
	private String confirmarSenha;
	
	public UsuarioBean() {
		
	}
	public String novo() {
		this.usuario = new Usuario();
		this.usuario.setAtivo(true);
		return "/publico/usuario";
	}
	public String salvar() {
		FacesContext context =FacesContext.getCurrentInstance();
		
		String senha = this.usuario.getSenha();
		if(!senha.equals(this.confirmarSenha)) {
			FacesMessage message = new FacesMessage("A senhas não são iguais, favor digitar corretamente.");
			context.addMessage(null, message);
			return null;
		}
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.salvar(this.usuario);
		return "usuariosucesso";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}
	

}
