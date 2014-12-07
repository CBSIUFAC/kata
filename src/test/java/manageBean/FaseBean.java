package manageBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import DAO.FaseDAO;
import entity.Fase;
@ManagedBean(name="faseBean")
@SessionScoped
public class FaseBean {
	private Fase fase;
    private FaseDAO faseDAO= new FaseDAO();
    
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
	
	private List<Fase> listaFase;
	
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

}
