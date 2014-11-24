package DAO;

import java.io.Serializable;
import java.util.List;





import org.hibernate.Query;
import org.hibernate.Session;

import entity.Dojo;
import util.HibernateUtil;

public class DojoDAO extends MasterDAO{
	//inserir
	public void inserirDojo(Dojo dojo){
		inserirObjeto(dojo);
	}
	//atualizar
	public void atualizarDojo(Dojo dojo){
		Session s = getSession();
		s.beginTransaction();
		s.update(dojo);
		s.getTransaction().commit();
		s.close();
	}
	//deletar
	public void deletarDojo(Dojo dojo){
		deletarObjeto(dojo);
	}
	//listar todos os dojos
	public List<Dojo> listarDojo(){
		Session s = getSession();
		s.beginTransaction();
		Query qr = s.createQuery("from Dojo c");
		List<Dojo> listaDojo = qr.list();
		s.close();
		return listaDojo;
	}
	
	public Dojo getDojo(int idDojo){
		Session s = getSession();
		s.beginTransaction();
		Dojo c = (Dojo) s.get(Dojo.class, idDojo);
		s.getTransaction().commit();
		s.close();
		return c;
	}
	
	public List<Dojo> buscarPorNomedoDojo(String nomeDojo){
		Session s = getSession();
		s.beginTransaction();
		Query qr = s.createQuery("from Dojo c where c.nomeDojo like :p");
		qr.setParameter("%"+nomeDojo+"%", "p");
		List<Dojo> listaDojos = qr.list();
		s.close();
		return listaDojos;
	}
	

	
}



