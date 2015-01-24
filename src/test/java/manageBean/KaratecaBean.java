package manageBean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import DAO.KaratecaDAO;
import entity.Karateca;

@ManagedBean
@SessionScoped
public class KaratecaBean {
	private Karateca karateca;
    private KaratecaDAO karatecaDAO= new KaratecaDAO();
    
    public void prepararK(){
		karateca = new Karateca();
	}
    
    public String inserirKarateca(){
		karatecaDAO.inserirKarateca(karateca);
		listaKarateca = null;
		return "listakaratecas";
	}
    public Karateca getKarateca() {
		if(karateca == null)
			karateca = new Karateca();
		return karateca;
	}

	public void setKarateca(Karateca karateca) {
		this.karateca = karateca;
	}
	
	private List<Karateca> listaKarateca =null;
	private List<Karateca> filtroLista = null;
	
	public List<Karateca> getListaKaratecas(){
		if(listaKarateca == null)
			listaKarateca = karatecaDAO.listarKarateca();
		return listaKarateca;
	}
	
	public List<Karateca> getFiltroLista() {
		return filtroLista;
	}
	public void setFiltroLista(List<Karateca> filtroLista) {
		this.filtroLista = filtroLista;
	}
	public String deletarKarateca(){
		karatecaDAO.deletarKarateca(karateca);
		listaKarateca = null;
		return "listakaratecas";
	}
	public void atualizarKarateca(RowEditEvent evento){
		karateca = (Karateca)evento.getObject();
		karatecaDAO.atualizarKarateca(karateca);
	}
	
	public void cancelarKarateca(RowEditEvent evento){
		FacesMessage msg = new FacesMessage("Edição Cancelada");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}
