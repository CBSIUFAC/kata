package manageBean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import DAO.FaseDAO;
import entity.Fase;
@ManagedBean(name="faseBean")
@SessionScoped
public class FaseBean {
	private Fase fase;
    private FaseDAO faseDAO= new FaseDAO();
    
    public void prepararF(){
     fase = new Fase();
    }
    public String inserirFase(){
		faseDAO.inserirFase(fase);
		listaFase = null;
		return "listafases";
	}
    public Fase getFase() {
		if(fase == null)
			fase = new Fase();
		return fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}
	
	private List<Fase> listaFase=null;
	public List<Fase> getFiltroLista() {
		return filtroLista;
	}
	public void setFiltroLista(List<Fase> filtroLista) {
		this.filtroLista = filtroLista;
	}

	private List<Fase> filtroLista=null;
	
	public List<Fase> getListaFases(){
		if(listaFase == null)
			listaFase = faseDAO.listarFase();
		return listaFase;
	}
	
	public String deletarFase(){
		faseDAO.deletarFase(fase);
		listaFase = null;
		return "listafases";
	}
	public void atualizarFase(RowEditEvent evento){
		fase = (Fase)evento.getObject();
		faseDAO.atualizarFase(fase);
	}
	
	public void cancelarFase(RowEditEvent evento){
		FacesMessage msg = new FacesMessage("Edição Cancelada");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}
