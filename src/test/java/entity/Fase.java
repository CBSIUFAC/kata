package entity;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Fase {//implements Serializable
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idFase;
	@Column
	private String nomeFase;
	@ManyToOne
	@JoinColumn(referencedColumnName="idEvento",name="fkCompeticao")
	private Competicao competicao;
	@OneToMany(mappedBy="fase")
	  private List<Apresentacao> apresentacao;
	public int getIdFase() {
		return idFase;
	}
	public void setIdFase(int idFase) {
		this.idFase = idFase;
	}
	public String getNomeFase() {
		return nomeFase;
	}
	public void setNomeFase(String nomeFase) {
		this.nomeFase = nomeFase;
	}
	public Competicao getCompeticao() {
		return competicao;
	}
	public void setCompeticao(Competicao competicao) {
		this.competicao = competicao;
	}
	public List<Apresentacao> getApresentacao() {
		return apresentacao;
	}
	public void setApresentacao(List<Apresentacao> apresentacao) {
		this.apresentacao = apresentacao;
	}
	public void setnomeFase(String nomeFase) {
		this.nomeFase = nomeFase;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idFase;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fase other = (Fase) obj;
		if (idFase != other.idFase)
			return false;
		return true;
	}
	
}
