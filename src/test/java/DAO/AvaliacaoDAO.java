package DAO;

import java.io.Serializable;
import java.util.List;





import org.hibernate.Query;
import org.hibernate.Session;

import entity.Avaliacao;
import util.HibernateUtil;

public class AvaliacaoDAO extends MasterDAO{
	//inserir
	public void inserirAvaliacao(Avaliacao avaliacao){
		inserirObjeto(avaliacao);
	}
	//atualizar
	public void atualizarAvaliacao(Avaliacao avaliacao){
		Session s = getSession();
		s.beginTransaction();
		s.update(avaliacao);
		s.getTransaction().commit();
		s.close();
	}
	//deletar
	public void deletarAvaliacao(Avaliacao avaliacao){
		deletarObjeto(avaliacao);
	}
	//listar todas os avaliacoes
	public List<Avaliacao> listarAvaliacao(){
		Session s = getSession();
		s.beginTransaction();
		Query qr = s.createQuery("from Avaliacao c");
		List<Avaliacao> listaAvaliacao = qr.list();
		s.close();
		return listaAvaliacao;
	}
	
	public Avaliacao getAvaliacao(int idAvaliacao){
		Session s = getSession();
		s.beginTransaction();
		Avaliacao c = (Avaliacao) s.get(Avaliacao.class, idAvaliacao);
		s.getTransaction().commit();
		s.close();
		return c;
	}
	
	public List<Avaliacao> buscarPorApresentacao(String apresentacao){
		Session s = getSession();
		s.beginTransaction();
		Query qr = s.createQuery("from Avaliacao c where c.apresentacao like :p");
		qr.setParameter("%"+apresentacao+"%", "p");
		List<Avaliacao> listaAvaliacoes = qr.list();
		s.close();
		return listaAvaliacoes;
	}
	

	
}



