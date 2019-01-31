package br.com.javaparaweb.financeiro.usuario;

import java.util.List;
import br.com.javaparaweb.financeiro.util.DaoFactory;

public class UsuarioRN {
	private UsuarioDao usuarioDao;

	public UsuarioRN() {
		this.usuarioDao = DaoFactory.criarUsuarioDao();
	}

	public Usuario carregar(Integer codigo) {
		return this.usuarioDao.carregar(codigo);
	}

	public Usuario buscarPorLogin(String login) {
		return this.usuarioDao.buscarPorLogin(login);
	}

	public void salvar(Usuario usuario) {

		Integer codigo = usuario.getCodigo();
		if (codigo == null || codigo == 0) {
			usuario.getPermissao().add("ROLE_USUARIO");
			this.usuarioDao.salvar(usuario);
		} else {
			this.usuarioDao.atualizar(usuario);
		}
	}

	public void excluir(Usuario usuario) {
		this.usuarioDao.excluir(usuario);
	}

	public List<Usuario> listar() {
		return this.usuarioDao.listar();
	}

}
