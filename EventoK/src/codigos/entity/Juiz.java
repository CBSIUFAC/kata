package entity;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity(name = "juiz")
public class Juiz {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int idJuiz;
	@Column
	private String nome;
	@OneToMany(mappedBy="juiz")
	  private List<Avaliacao> avaliacoes;
	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}
	
	public int getIdJui() {
		return idJuiz;
	}
	public void setIdJui(int idJui) {
		idJuiz = idJui;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}