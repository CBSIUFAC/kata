package manageBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import DAO.AvaliacaoDAO;
import entity.Avaliacao;

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

	public void setJuiz(Avaliacao avaliacao) {
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
}
