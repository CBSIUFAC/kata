package manageBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import DAO.ApresentacaoDAO;
import entity.Apresentacao;
import entity.Avaliacao;

@ManagedBean(name="processaBean")
@SessionScoped
public class Processa {
	 ApresentacaoDAO apresentacaoDAO2 =new ApresentacaoDAO();
	 public void atualizaDado(ActionEvent actionEvent){
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
