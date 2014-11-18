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
}
