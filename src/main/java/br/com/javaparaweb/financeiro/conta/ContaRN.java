package br.com.javaparaweb.financeiro.conta;

import java.util.Date;
import java.util.List;
import br.com.javaparaweb.financeiro.usuario.Usuario;
import br.com.javaparaweb.financeiro.util.DaoFactory;

public class ContaRN {
	private ContaDao contaDao;
	
	public ContaRN() {
		this.contaDao = DaoFactory.criarContaDao();
	}
	
	public List<Conta> listar(Usuario usuario){
		return this.contaDao.listar(usuario);	
	}
	
	public Conta carregar(Integer conta) {
		return this.contaDao.carregar(conta);	
	}
	
	public void salvar(Conta conta) {
		conta.setDataCadastro(new Date());
		this.contaDao.salvar(conta);
	}
	
	public void excluir(Conta conta) {
		this.contaDao.excluir(conta);
	}
	
	public void tornarFavorita(Conta contaFavorita) {
		Conta conta = this.buscarFavorita(contaFavorita.getUsuario());
		if(conta != null) {
			conta.setFavorita(false);
			this.contaDao.salvar(conta);
		}
		contaFavorita.setFavorita(true);
		this.contaDao.salvar(contaFavorita);
	}
	
	public Conta buscarFavorita(Usuario usuario) {
		return this.contaDao.buscarFavorita(usuario);
	}
}
