package manageBean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import DAO.KataDAO;
import entity.Kata;

@ManagedBean
@SessionScoped
public class KataBean {
    private Kata kata;
    private KataDAO kataDAO = new KataDAO();
    public String inserirKata(){
 		kataDAO.inserirKata(kata);
 		listaKata = null;
 		return "listakatas";
 	}
     public Kata getKata() {
 		if(kata == null)
 			kata = new Kata();
 		return kata;
 	}

 	public void setKata(Kata kata) {
 		this.kata = kata;
 	}
 	
 	private List<Kata> listaKata=null;
 	public List<Kata> getFiltroLista() {
		return filtroLista;
	}
	public void setFiltroLista(List<Kata> filtroLista) {
		this.filtroLista = filtroLista;
	}

	private List<Kata> filtroLista=null;
 	
 	public List<Kata> getListaKatas(){
 		if(listaKata == null)
 			listaKata = kataDAO.listarKata();
 		return listaKata;
 	}
 	
 	public String deletarKata(){
 		kataDAO.deletarKata(kata);
 		listaKata = null;
 		return "listakatas";
 	}
 	public void atualizarKata(RowEditEvent evento){
		kata = (Kata)evento.getObject();
		kataDAO.atualizarKata(kata);
	}
	
	public void cancelarKata(RowEditEvent evento){
		FacesMessage msg = new FacesMessage("Edição Cancelada");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}
