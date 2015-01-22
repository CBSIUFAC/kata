package manageBean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import DAO.ApresentacaoDAO;
import entity.Apresentacao;
import entity.Avaliacao;

@ManagedBean(name="apresentacaoBean")
@SessionScoped
public class ApresentacaoBean {
	private Apresentacao apresentacao;
	private ApresentacaoDAO apresentacaoDAO = new ApresentacaoDAO();
	private float media;
	
	public String inserirApresentacao(){
		
		apresentacaoDAO.inserirApresentacao(apresentacao);
		
		listaApresentacao = null;
		return "listaapresentacoes";
	}
	public Apresentacao getApresentacao() {
		if(apresentacao == null)
			apresentacao = new Apresentacao();
		return apresentacao;
	}

	public void setApresentacao(Apresentacao apresentacao) {
		this.apresentacao = apresentacao;
	}

	private List<Apresentacao> listaApresentacao=null;
	private List<Apresentacao> filtroLista=null;

	public List<Apresentacao> getListaApresentacoes(){
		if(listaApresentacao == null)
			listaApresentacao = apresentacaoDAO.listarApresentacao();
		return listaApresentacao;
	}
	public List<Apresentacao> getFiltroLista() {
		return filtroLista;
	}
	public void setFiltroLista(List<Apresentacao> filtroLista) {
		this.filtroLista = filtroLista;
	}

	public String deletarApresentacao(){
		apresentacaoDAO.deletarApresentacao(apresentacao);
		listaApresentacao = null;
		return "listaapresentacoes";
	}

	public void atualizarApresentacao(RowEditEvent evento){
		apresentacao = (Apresentacao)evento.getObject();
		
		apresentacao.setPontuacao(calculaMedia());
		apresentacaoDAO.atualizarApresentacao(apresentacao);
	}

	public void cancelarApresentacao(RowEditEvent evento){
		FacesMessage msg = new FacesMessage("Edição Cancelada");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public float calculaMedia(){
		float media = 0;
		List<Avaliacao> avaliacoes = apresentacao.getAvaliacao();
		for(Avaliacao a: avaliacoes){
			media += a.getNota(); 
		}		
		return (media/avaliacoes.size());
	}
	public ApresentacaoDAO getApresentacaoDAO() {
		return apresentacaoDAO;
	}
	public void setApresentacaoDAO(ApresentacaoDAO apresentacaoDAO) {
		this.apresentacaoDAO = apresentacaoDAO;
	}
	
	public float getMedia() {
		return calculaMedia();
	}
	
	public void setMedia(float media) {
		this.media = media;
	}
	public List<Apresentacao> getListaApresentacao() {
		return listaApresentacao;
	}
	public void setListaApresentacao(List<Apresentacao> listaApresentacao) {
		this.listaApresentacao = listaApresentacao;
	}
}
