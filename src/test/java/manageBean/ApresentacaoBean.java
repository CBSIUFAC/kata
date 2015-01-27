package manageBean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.RowEditEvent;

import DAO.ApresentacaoDAO;
import entity.Apresentacao;
import entity.Avaliacao;

@ManagedBean(name="apresentacaoBean")
@SessionScoped
public class ApresentacaoBean {
	private Apresentacao apresentacao;
	private ApresentacaoDAO apresentacaoDAO = new ApresentacaoDAO();
	
	public void prepararAp(){
		apresentacao = new Apresentacao();
	}
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
		/*List<Apresentacao> ap = apresentacaoDAO.listarApresentacao();
		if(ap != null){
			for(Apresentacao a: ap){
				a.setPontuacao(calculaMedia(a));
				System.out.println(calculaMedia(a));
				apresent2.atualizarApresentacao(a);;
			}	
		}*/	
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
	}

	public void cancelarApresentacao(RowEditEvent evento){
		FacesMessage msg = new FacesMessage("Edição Cancelada");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	

	public ApresentacaoDAO getApresentacaoDAO() {
		return apresentacaoDAO;
	}
	public void setApresentacaoDAO(ApresentacaoDAO apresentacaoDAO) {
		this.apresentacaoDAO = apresentacaoDAO;
	}
   
	ApresentacaoDAO apresentacaoDAO2 =new ApresentacaoDAO();
	 public String atualizaDado(){
		 List<Apresentacao> ap = apresentacaoDAO2.listarApresentacao();
		 float num;
		 if(ap != null){
			 for(Apresentacao a: ap){			
				 if(calculaMedia(a)!= 0)
					 num = calculaMedia(a);
				 else
					 num = 0;
				 a.setPontuacao(calculaMedia(a));
				 System.out.println(calculaMedia(a));
				 apresentacaoDAO2.atualizarApresentacao(a);
			 }	
		 }
		 listaApresentacao = null;
			return "listaapresentacoes";
	 }
	public float calculaMedia(Apresentacao apresentacao){
		float media = 0;
		List<Avaliacao> avaliacoes = apresentacao.getAvaliacao();
		if(avaliacoes != null){
			for(Avaliacao a: avaliacoes){
				media = media + a.getNota(); 
			}		
			
			return media/avaliacoes.size();
			
		}
		else{
			return (float) 0;
		}
	}
	
}
