package manageBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import DAO.JuizDAO;
import entity.Juiz;
@ManagedBean(name="juizBean")
@SessionScoped
public class JuizBean {
     private Juiz juiz;
     private JuizDAO juizDAO= new JuizDAO();
     
     public String inserirJuiz(){
 		juizDAO.inserirJuiz(juiz);
 		listaJuiz = null;
 		return "listajuizes";
 	}
     public Juiz getJuiz() {
 		if(juiz == null)
 			juiz = new Juiz();
 		return juiz;
 	}

 	public void setJuiz(Juiz juiz) {
 		this.juiz = juiz;
 	}
 	
 	private List<Juiz> listaJuiz=null;
 	
 	public List<Juiz> getListaJuiz() {
		return listaJuiz;
	}
	public void setListaJuiz(List<Juiz> listaJuiz) {
		this.listaJuiz = listaJuiz;
	}
	public List<Juiz> getListaJuizes(){
 		if(listaJuiz == null)
 			listaJuiz = juizDAO.listarJuiz();
 		return listaJuiz;
 	}
 	
 	public String deletarJuiz(){
 		juizDAO.deletarJuiz(juiz);
 		listaJuiz = null;
 		return "listajuizes";
 	}
}
