package manageBean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import DAO.ApresentacaoDAO;
import DAO.AvaliacaoDAO;
import entity.Apresentacao;
import entity.Avaliacao;

@ManagedBean(name="avaliacaoBean")
@SessionScoped
public class AvaliacaoBean {
	private Avaliacao avaliacao;
	private Apresentacao apresentacao;
    private AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
    public ApresentacaoDAO getApresentacaoDAO() {
		return apresentacaoDAO;
	}

	public void setApresentacaoDAO(ApresentacaoDAO apresentacaoDAO) {
		this.apresentacaoDAO = apresentacaoDAO;
	}

	private ApresentacaoDAO apresentacaoDAO = new ApresentacaoDAO();
    private ApresentacaoBean abean = new ApresentacaoBean();
    
    public String inserirAvaliacao(){
    	
		avaliacaoDAO.inserirAvaliacao(avaliacao);
	
		
		listaAvaliacao = null;
		return "listaavaliacoes";
	}
    
    public AvaliacaoDAO getAvaliacaoDAO() {
		return avaliacaoDAO;
	}
	public void setAvaliacaoDAO(AvaliacaoDAO avaliacaoDAO) {
		this.avaliacaoDAO = avaliacaoDAO;
	}
	public ApresentacaoBean getAbean() {
		return abean;
	}
	public void setAbean(ApresentacaoBean abean) {
		this.abean = abean;
	}
	public void setListaAvaliacao(List<Avaliacao> listaAvaliacao) {
		this.listaAvaliacao = listaAvaliacao;
	}
	public Avaliacao getAvaliacao() {
		if(avaliacao == null)
			avaliacao = new Avaliacao();
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	private List<Avaliacao> listaAvaliacao=null;
	private List<Avaliacao> filtroLista=null;
	
	public List<Avaliacao> getFiltroLista() {
		return filtroLista;
	}
	public void setFiltroLista(List<Avaliacao> filtroLista) {
		this.filtroLista = filtroLista;
	}
	public List<Avaliacao> getListaAvaliacao(){
		if(listaAvaliacao == null)
			listaAvaliacao = avaliacaoDAO.listarAvaliacao();
		return listaAvaliacao;
	}
	
	public String deletarAvaliacao(){
		avaliacaoDAO.deletarAvaliacao(avaliacao);
		listaAvaliacao = null;
		return "listaavaliacoes";
	}
	public void atualizarAvaliacao(RowEditEvent evento){
		avaliacao = (Avaliacao)evento.getObject();
		avaliacaoDAO.atualizarAvaliacao(avaliacao);
	}
	
	public void cancelarAvaliacao(RowEditEvent evento){
		FacesMessage msg = new FacesMessage("Edição Cancelada");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public Apresentacao getApresentacao() {
		return apresentacao;
	}

	public void setApresentacao(Apresentacao apresentacao) {
		this.apresentacao = apresentacao;
	}
	public float calculaMedia(){
		float media = 0;
		List<Avaliacao> avaliacoes = apresentacao.getAvaliacao();
		for(Avaliacao a: avaliacoes){
			media += a.getNota(); 
		}		
		return (media/avaliacoes.size());
	}
}
