package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Avaliacao implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idAvalia;
	@Column
	private float nota;
	@ManyToOne
	@JoinColumn(referencedColumnName="idJuiz",name="fkJuiz")
	private Juiz juiz;
	@ManyToOne
	@JoinColumn(referencedColumnName="idApresenta",name="fkApresenta")
	private Apresentacao apresentacao;
	
	public int getIdAvalia() {
		return idAvalia;
	}
	public void setIdAvalia(int idAvalia) {
		this.idAvalia = idAvalia;
	}
	public float getNota() {
		return nota;
	}
	public void setNota(float nota) {
		this.nota = nota;
	}
	public Juiz getJuiz() {
		return juiz;
	}
	public void setJuiz(Juiz juiz) {
		this.juiz = juiz;
	}
	public Apresentacao getApresentacao() {
		return apresentacao;
	}
	public void setApresentacao(Apresentacao apresentacao) {
		this.apresentacao = apresentacao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idAvalia;
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
		Avaliacao other = (Avaliacao) obj;
		if (idAvalia != other.idAvalia)
			return false;
		return true;
	}
    
}
