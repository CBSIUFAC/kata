package manageBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import DAO.CompeticaoDAO;
import entity.Competicao;
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
  	
  	private List<Competicao> listaCompeticao;
  	
  	public List<Competicao> getListaCompeticoes(){
  		if(listaCompeticao == null)
  			listaCompeticao = competicaoDAO.listarCompeticao();
  		return listaCompeticao;
  	}
  	
  	public String deletarCompeticao(){
  		competicaoDAO.deletarCompeticao(competicao);
  		listaCompeticao = null;
  		return "listacompeticoes";
  	}
}
