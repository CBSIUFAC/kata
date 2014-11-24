package DAO;

import java.io.Serializable;
import java.util.List;





import org.hibernate.Query;
import org.hibernate.Session;

import entity.Fase;
import util.HibernateUtil;

public class FaseDAO extends MasterDAO{
	//inserir
	public void inserirFase(Fase fase){
		inserirObjeto(fase);
	}
	//atualizar
	public void atualizarFase(Fase fase){
		Session s = getSession();
		s.beginTransaction();
		s.update(fase);
		s.getTransaction().commit();
		s.close();
	}
	//deletar
	public void deletarFase(Fase fase){
		deletarObjeto(fase);
	}
	//listar todas as fases
	public List<Fase> listarFase(){
		Session s = getSession();
		s.beginTransaction();
		Query qr = s.createQuery("from Fase c");
		List<Fase> listaFase = qr.list();
		s.close();
		return listaFase;
	}
	
	public Fase getFase(int idFase){
		Session s = getSession();
		s.beginTransaction();
		Fase c = (Fase) s.get(Fase.class, idFase);
		s.getTransaction().commit();
		s.close();
		return c;
	}
	
	public List<Fase> buscarPorFase(String fase){
		Session s = getSession();
		s.beginTransaction();
		Query qr = s.createQuery("from Fase c where c.fase like :p");
		qr.setParameter("%"+fase+"%", "p");
		List<Fase> listaFases = qr.list();
		s.close();
		return listaFases;
	}
	

	
}



