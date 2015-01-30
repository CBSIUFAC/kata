package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import entity.Usuario;
public class UsuarioDAO extends MasterDAO{
	public void inserirUsuario(Usuario usu){
		inserirObjeto(usu);
	}
	public void atualizarUsuario(Usuario usu){
		atualizarObjeto(usu);
	}
	public void deletarUsuario(Usuario usu){
		deletarObjeto(usu);
	}
	public List<Usuario> getListaUsuario(){
		Session s = getSession();
		s.beginTransaction();
		Query qr = s.createQuery("from Usuario c");
		List<Usuario> listaUsuario = qr.list();
		s.close();
		return listaUsuario;
	}
	
	public Usuario getUsuario(String usuario){
		Session s = getSession();
		s.beginTransaction();
		Usuario c = (Usuario) s.get(Usuario.class, usuario);
		s.getTransaction().commit();
		s.close();
		return c;
	}

}
