package manageBean;

import java.util.Collections;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import DAO.CompeticaoDAO;
import entity.Apresentacao;
import entity.Competicao;

@ManagedBean(name="competicaoBean")
@SessionScoped
public class CompeticaoBean {
     private Competicao competicao;
     private CompeticaoDAO competicaoDAO = new CompeticaoDAO();
     private int colocacao;
     public void prepararC(){
 		competicao = new Competicao();
 	}
    
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
  	private List<Apresentacao> lista;
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
	//Serve para pegar o objeto de forma temporal, para mostrar informações
	private Competicao selectedC;

	public Competicao getSelectedC() {
		return selectedC;
	}

	public void setSelectedC(Competicao selectedC) {
		this.selectedC = selectedC;
	}
	
	public List<Apresentacao> getLista() {
		List<Apresentacao> listaOrdenada = competicao.getApresentacao();
		
		Collections.sort(listaOrdenada);
		
		return listaOrdenada;
	}

	public CompeticaoDAO getCompeticaoDAO() {
		return competicaoDAO;
	}

	public void setCompeticaoDAO(CompeticaoDAO competicaoDAO) {
		this.competicaoDAO = competicaoDAO;
	}

	public List<Competicao> getListaCompeticao() {
		return listaCompeticao;
	}

	public void setListaCompeticao(List<Competicao> listaCompeticao) {
		this.listaCompeticao = listaCompeticao;
	}

	public void setLista(List<Apresentacao> lista) {
		this.lista = lista;
	}

		public String getColocacao(){
			colocacao++;
			return colocacao+"ºColocado";
		}
}
