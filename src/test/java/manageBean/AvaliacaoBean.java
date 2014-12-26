package manageBean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import DAO.AvaliacaoDAO;
import entity.Avaliacao;
import entity.Dojo;

@ManagedBean(name="avaliacaoBean")
@SessionScoped
public class AvaliacaoBean {
	private Avaliacao avaliacao;
    private AvaliacaoDAO avaliacaoDAO= new AvaliacaoDAO();
    
    public String inserirAvaliacao(){
		avaliacaoDAO.inserirAvaliacao(avaliacao);
		listaAvaliacao = null;
		return "listaavaliacoes";
	}
    public Avaliacao getAvaliacao() {
		if(avaliacao == null)
			avaliacao = new Avaliacao();
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	private List<Avaliacao> listaAvaliacao;
	
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
}
