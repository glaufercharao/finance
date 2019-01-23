package br.com.javaparaweb.financeiro.usuario;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;


public class UsuarioDaoHibernate implements UsuarioDao {
	private Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}

	public UsuarioDaoHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void salvar(Usuario usuario) {
		this.session.save(usuario);

	}

	@Override
	public void atualizar(Usuario usuario) {
		this.session.update(usuario);

	}

	@Override
	public void excluir(Usuario usuario) {
		this.session.delete(usuario);

	}

	@Override
	public Usuario carregar(Integer codigo) {
		return (Usuario) this.session.get(Usuario.class, codigo);
	}
	
	@Override
	public List<Usuario> listar() {
		return this.session.createCriteria(Usuario.class).list();

	}

	@Override
	public Usuario buscarPorLogin(String login) {
		String hql = "select u from Usuario where u.login = :login";
		Query select = this.session.createQuery(hql);
		select.setString("login", login);
		return (Usuario) select.uniqueResult();

	}

}
