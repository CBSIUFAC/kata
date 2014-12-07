package manageBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import DAO.DojoDAO;
import entity.Dojo;
@ManagedBean(name="dojoBean")
@SessionScoped
public class DojoBean {
	private Dojo dojo;
    private DojoDAO dojoDAO= new DojoDAO();
    
    public String inserirDojo(){
		dojoDAO.inserirDojo(dojo);
		listaDojo = null;
		return "listadojos";
	}
    public Dojo getDojo() {
		if(dojo == null)
			dojo = new Dojo();
		return dojo;
	}

	public void setDojo(Dojo dojo) {
		this.dojo = dojo;
	}
	
	private List<Dojo> listaDojo;
	
	public List<Dojo> getListaDojos(){
		if(listaDojo == null)
			listaDojo = dojoDAO.listarDojo();
		return listaDojo;
	}
	
	public String deletarDojo(){
		dojoDAO.deletarDojo(dojo);
		listaDojo = null;
		return "listadojos";
	}
}
