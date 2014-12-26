package manageBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import DAO.KaratecaDAO;
import entity.Karateca;

@ManagedBean
@SessionScoped
public class KaratecaBean {
	private Karateca karateca;
    private KaratecaDAO karatecaDAO= new KaratecaDAO();
    
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
	
	private List<Karateca> listaKarateca;
	
	public List<Karateca> getListaKaratecas(){
		if(listaKarateca == null)
			listaKarateca = karatecaDAO.listarKarateca();
		return listaKarateca;
	}
	
	public String deletarKarateca(){
		karatecaDAO.deletarKarateca(karateca);
		listaKarateca = null;
		return "listakaratecas";
	}
}
