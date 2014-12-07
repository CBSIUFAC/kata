package manageBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
 	
 	private List<Kata> listaKata;
 	
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
}
