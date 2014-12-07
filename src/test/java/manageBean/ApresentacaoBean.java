package manageBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import DAO.ApresentacaoDAO;
import entity.Apresentacao;

@ManagedBean(name="apresentacaoBean")
@SessionScoped
public class ApresentacaoBean {
	private Apresentacao apresentacao;
    private ApresentacaoDAO apresentacaoDAO= new ApresentacaoDAO();
    
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
	
	private List<Apresentacao> listaApresentacao;
	
	public List<Apresentacao> getListaApresentacoes(){
		if(listaApresentacao == null)
			listaApresentacao = apresentacaoDAO.listarApresentacao();
		return listaApresentacao;
	}
	
	public String deletarApresentacao(){
		apresentacaoDAO.deletarApresentacao(apresentacao);
		listaApresentacao = null;
		return "listaapresentacoes";
	}
}
