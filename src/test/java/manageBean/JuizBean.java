package manageBean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

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
 	private List<Juiz> filtroLista=null;
 	
	public List<Juiz> getFiltroLista() {
		return filtroLista;
	}
	public void setFiltroLista(List<Juiz> filtroLista) {
		this.filtroLista = filtroLista;
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
 	public void atualizarJuiz(RowEditEvent evento){
		juiz = (Juiz)evento.getObject();
		juizDAO.atualizarJuiz(juiz);
	}
	
	public void cancelarJuiz(RowEditEvent evento){
		FacesMessage msg = new FacesMessage("Edição Cancelada");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}
