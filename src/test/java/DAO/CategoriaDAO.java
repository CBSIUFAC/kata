package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entity.Categoria;

public class CategoriaDAO extends MasterDAO {
	//inserir
		public void inserirCategoria(Categoria categoria){
			inserirObjeto(categoria);
		}
		//atualizar
		public void atualizarCategoria(Categoria categoria){
		     atualizarObjeto(categoria);
		}
		//deletar
		public void deletarCategoria(Categoria categoria){
			deletarObjeto(categoria);
		}
	
		public List<Categoria> listarCategoria(){
			Session s = getSession();
			s.beginTransaction();
			Query qr = s.createQuery("from Categoria c");
			List<Categoria> listaCategoria = qr.list();
			s.close();
			return listaCategoria;
		}
		
		public Categoria getCategoria(String idCategoria){
			Session s = getSession();
			s.beginTransaction();
			Categoria c = (Categoria) s.get(Categoria.class, idCategoria);
			s.getTransaction().commit();
			s.close();
			return c;
		}
		
		public List<Categoria> buscarPorNome(String nome){
			Session s = getSession();
			s.beginTransaction();
			Query qr = s.createQuery("from Categoria c where c.nome like :p");
			qr.setParameter("%"+nome+"%", "p");
			List<Categoria> listaCategoria = qr.list();
			s.close();
			return listaCategoria;
		}
}
