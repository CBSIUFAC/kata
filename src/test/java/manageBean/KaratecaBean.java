package manageBean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import DAO.CategoriaDAO;
import DAO.KaratecaDAO;
import entity.Categoria;
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
	KaratecaDAO karatecaDAO2 =new KaratecaDAO();
	 public String classificador(){
		 List<Karateca> kartecs = karatecaDAO2.listarKarateca();
		 Categoria temp2 = null;
		 if(kartecs != null){
			 for(Karateca kartc: kartecs){
				 if(kartc.getCategoria() == null){
			        temp2 = classifica(kartc);
				     if(temp2!=null){
				      kartc.setCategoria(temp2);
				      karatecaDAO2.atualizarKarateca(kartc);
				      }
				 }
			 }	
		 }
		 listaKarateca = null;
			return "listakaratecas";
	 }
	 CategoriaDAO categoDAO = new CategoriaDAO();
	public Categoria classifica(Karateca karatega){
		Categoria temp = null;
		List<Categoria> categors = categoDAO.listarCategoria();
		    int faixa = karatega.getFaixa();
		    int   idade = karatega.getIdade();
			for(Categoria cat: categors){ 
				if(cat.getFaixaMin()<=faixa&&faixa<=cat.getFaixaMax()&&(cat.getMin()<=idade)&& (idade<= cat.getMax()))
				{  temp = cat;
				}
			}	
			return temp;
	}
}
