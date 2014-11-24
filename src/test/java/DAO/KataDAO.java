package DAO;

import java.io.Serializable;
import java.util.List;





import org.hibernate.Query;
import org.hibernate.Session;

import entity.Kata;
import util.HibernateUtil;

public class KataDAO extends MasterDAO{
	//inserir
	public void inserirKata(Kata kata){
		inserirObjeto(kata);
	}
	//atualizar
	public void atualizarKata(Kata kata){
		Session s = getSession();
		s.beginTransaction();
		s.update(kata);
		s.getTransaction().commit();
		s.close();
	}
	//deletar
	public void deletarKata(Kata kata){
		deletarObjeto(kata);
	}
	//listar todos os katas
	public List<Kata> listarKata(){
		Session s = getSession();
		s.beginTransaction();
		Query qr = s.createQuery("from Kata c");
		List<Kata> listaKata = qr.list();
		s.close();
		return listaKata;
	}
	
	public Kata getKata(int idKata){
		Session s = getSession();
		s.beginTransaction();
		Kata c = (Kata) s.get(Kata.class, idKata);
		s.getTransaction().commit();
		s.close();
		return c;
	}
	
	public List<Kata> buscarPorNomedaKata(String nomeKata){
		Session s = getSession();
		s.beginTransaction();
		Query qr = s.createQuery("from Kata c where c.nomeKata like :p");
		qr.setParameter("%"+nomeKata+"%", "p");
		List<Kata> listaKatas = qr.list();
		s.close();
		return listaKatas;
	}
	

	
}



