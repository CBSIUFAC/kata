package manageBean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import DAO.CompeticaoDAO;
import entity.Competicao;

@ManagedBean(name="competicaoBean")
@SessionScoped
public class CompeticaoBean {
     private Competicao competicao;
     private CompeticaoDAO competicaoDAO = new CompeticaoDAO();
    
     public String inserirCompeticao(){
  		competicaoDAO.inserirCompeticao(competicao);
  		listaCompeticao = null;
  		return "listacompeticoes";
  	}
      public Competicao getCompeticao() {
  		if(competicao == null)
  			competicao = new Competicao();
  		return competicao;
  	}

  	public void setCompeticao(Competicao competicao) {
  		this.competicao = competicao;
  	}
  	
  	private List<Competicao> listaCompeticao=null;
  	private List<Competicao> filtroLista=null;
  	
  	public List<Competicao> getListaCompeticoes(){
  		if(listaCompeticao == null)
  			listaCompeticao = competicaoDAO.listarCompeticao();
  		return listaCompeticao;
  	}
  	
  	public List<Competicao> getFiltroLista() {
		return filtroLista;
	}
	public void setFiltroLista(List<Competicao> filtroLista) {
		this.filtroLista = filtroLista;
	}
	public String deletarCompeticao(){
  		competicaoDAO.deletarCompeticao(competicao);
  		listaCompeticao = null;
  		return "listacompeticoes";
  	}
	public void atualizarCompeticao(RowEditEvent evento){
		competicao = (Competicao)evento.getObject();
		competicaoDAO.atualizarCompeticao(competicao);
	}
	
	public void cancelarCompeticao(RowEditEvent evento){
		FacesMessage msg = new FacesMessage("Edição Cancelada");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}
