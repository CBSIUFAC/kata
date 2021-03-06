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
    private AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
    private Apresentacao apresentacao = new Apresentacao();
    
    public void prepararA(){
    	avaliacao = new Avaliacao();
    }
    
    public String inserirAvaliacao() {
    	/*System.out.println("a");
    	
    	/*System.out.println("b");
    	apresentacao.setPontuacao(abean.calculaMedia(apresentacao));
    	System.out.println(abean.calculaMedia(apresentacao)+" Result");
    	System.out.println("c");
		apresentacaoDAO.atualizarApresentacao(apresentacao);
		System.out.println("Novo");*/
    	avaliacao.setApresentacao(apresentacao);
    	avaliacaoDAO.inserirAvaliacao(avaliacao);
    	System.out.println(apresentacao.getNomeApresenta());
		listaAvaliacao = null;
		return "listaavaliacoes";
	}
    
    public AvaliacaoDAO getAvaliacaoDAO() {
		return avaliacaoDAO;
	}
	public void setAvaliacaoDAO(AvaliacaoDAO avaliacaoDAO) {
		this.avaliacaoDAO = avaliacaoDAO;
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
		FacesMessage msg = new FacesMessage("Edi��o Cancelada");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public Apresentacao getApresentacao() {
		if(apresentacao == null)
			apresentacao = new Apresentacao();
		return apresentacao;
	}

	public void setApresentacao(Apresentacao apresentacao) {
		this.apresentacao = apresentacao;
	}
	
}
