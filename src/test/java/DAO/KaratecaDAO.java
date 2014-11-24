package DAO;

import java.io.Serializable;
import java.util.List;





import org.hibernate.Query;
import org.hibernate.Session;

import entity.Karateca;
import util.HibernateUtil;

public class KaratecaDAO extends MasterDAO{
	//inserir
	public void inserirKarateca(Karateca karateca){
		inserirObjeto(karateca);
	}
	//atualizar
	public void atualizarKarateca(Karateca karateca){
		Session s = getSession();
		s.beginTransaction();
		s.update(karateca);
		s.getTransaction().commit();
		s.close();
	}
	//deletar
	public void deletarKarateca(Karateca karateca){
		deletarObjeto(karateca);
	}
	//listar todos os karatecas
	public List<Karateca> listarKarateca(){
		Session s = getSession();
		s.beginTransaction();
		Query qr = s.createQuery("from Karateca c");
		List<Karateca> listaKarateca = qr.list();
		s.close();
		return listaKarateca;
	}
	
	public Karateca getKarateca(String rgKarateca){
		Session s = getSession();
		s.beginTransaction();
		Karateca c = (Karateca) s.get(Karateca.class, rgKarateca);
		s.getTransaction().commit();
		s.close();
		return c;
	}
	
	public List<Karateca> buscarPorNome(String nome){
		Session s = getSession();
		s.beginTransaction();
		Query qr = s.createQuery("from Karateca c where c.nome like :p");
		qr.setParameter("%"+nome+"%", "p");
		List<Karateca> listaKaratecas = qr.list();
		s.close();
		return listaKaratecas;
	}
	

	
}



