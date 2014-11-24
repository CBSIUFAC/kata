package DAO;

import java.io.Serializable;
import java.util.List;





import org.hibernate.Query;
import org.hibernate.Session;

import entity.Juiz;
import util.HibernateUtil;

public class JuizDAO extends MasterDAO{
	//inserir
	public void inserirJuiz(Juiz juiz){
		inserirObjeto(juiz);
	}
	//atualizar
	public void atualizarJuiz(Juiz juiz){
		Session s = getSession();
		s.beginTransaction();
		s.update(juiz);
		s.getTransaction().commit();
		s.close();
	}
	//deletar
	public void deletarJuiz(Juiz juiz){
		deletarObjeto(juiz);
	}
	//listar todos os juizes
	public List<Juiz> listarJuiz(){
		Session s = getSession();
		s.beginTransaction();
		Query qr = s.createQuery("from Juiz c");
		List<Juiz> listaJuiz = qr.list();
		s.close();
		return listaJuiz;
	}
	
	public Juiz getJuiz(int idJuiz){
		Session s = getSession();
		s.beginTransaction();
		Juiz c = (Juiz) s.get(Juiz.class, idJuiz);
		s.getTransaction().commit();
		s.close();
		return c;
	}
	
	public List<Juiz> buscarPorNome(String nome){
		Session s = getSession();
		s.beginTransaction();
		Query qr = s.createQuery("from Juiz c where c.nome like :p");
		qr.setParameter("%"+nome+"%", "p");
		List<Juiz> listaJuizes = qr.list();
		s.close();
		return listaJuizes;
	}
	

	
}



