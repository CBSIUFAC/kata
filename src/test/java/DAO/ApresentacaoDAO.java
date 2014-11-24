package DAO;

import java.io.Serializable;
import java.util.List;





import org.hibernate.Query;
import org.hibernate.Session;

import entity.Apresentacao;
import util.HibernateUtil;

public class ApresentacaoDAO extends MasterDAO{
	//inserir
	public void inserirApresentacao(Apresentacao apresentacao){
		inserirObjeto(apresentacao);
	}
	//atualizar
	public void atualizarApresentacao(Apresentacao apresentacao){
		Session s = getSession();
		s.beginTransaction();
		s.update(apresentacao);
		s.getTransaction().commit();
		s.close();
	}
	//deletar
	public void deletarApresentacao(Apresentacao apresentacao){
		deletarObjeto(apresentacao);
	}
	//listar todas as apresentacoes
	public List<Apresentacao> listarApresentacao(){
		Session s = getSession();
		s.beginTransaction();
		Query qr = s.createQuery("from Apresentacao c");
		List<Apresentacao> listaApresentacao = qr.list();
		s.close();
		return listaApresentacao;
	}
	
	public Apresentacao getApresentacao(int idApresentacao){
		Session s = getSession();
		s.beginTransaction();
		Apresentacao c = (Apresentacao) s.get(Apresentacao.class, idApresentacao);
		s.getTransaction().commit();
		s.close();
		return c;
	}
	
	public List<Apresentacao> buscarPorKata(String kata){
		Session s = getSession();
		s.beginTransaction();
		Query qr = s.createQuery("from kata c where c.kata like :p");
		qr.setParameter("%"+kata+"%", "p");
		List<Apresentacao> listaApresentacaos = qr.list();
		s.close();
		return listaApresentacaos;
	}
	

	
}



