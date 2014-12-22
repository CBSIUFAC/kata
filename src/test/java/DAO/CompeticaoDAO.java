package DAO;

import java.io.Serializable;
import java.util.List;





import org.hibernate.Query;
import org.hibernate.Session;

import entity.Competicao;
import util.HibernateUtil;

public class CompeticaoDAO extends MasterDAO{
	//inserir
	public void inserirCompeticao(Competicao competicao){
		inserirObjeto(competicao);
	}
	//atualizar
	public void atualizarCompeticao(Competicao competicao){
		Session s = getSession();
		s.beginTransaction();
		s.update(competicao);
		s.getTransaction().commit();
		s.close();
	}
	//deletar
	public void deletarCompeticao(Competicao competicao){
		deletarObjeto(competicao);
	}
	//listar todos as competicoes
	public List<Competicao> listarCompeticao(){
		Session s = getSession();
		s.beginTransaction();
		Query qr = s.createQuery("from Competicao c");
		List<Competicao> listaCompeticao = qr.list();
		s.close();
		return listaCompeticao;
	}
	
	public Competicao getCompeticao(int idEvento){
		Session s = getSession();
		s.beginTransaction();
		Competicao c = (Competicao) s.get(Competicao.class, idEvento);
		s.getTransaction().commit();
		s.close();
		return c;
	}
	
	public List<Competicao> buscarPorNomedoEvento(String nomeEvento){
		Session s = getSession();
		s.beginTransaction();
		Query qr = s.createQuery("from Competicao c where c.nomeEvento like :p");
		qr.setParameter("p","%"+nomeEvento+"%");
		List<Competicao> listaCompeticoes = qr.list();
		s.close();
		return listaCompeticoes;
	}
	

	
}



