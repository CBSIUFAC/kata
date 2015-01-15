package entity;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Kata { //implements Serializable
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int idKata;
	@Column
    private String nomeKata;
	@Column
    private int passos;
	@OneToMany(mappedBy="kata")
	  private List<Apresentacao> apresentacao;
	public int getIdKata() {
		return idKata;
	}
	public void setIdKata(int idKata) {
		this.idKata = idKata;
	}
	public List<Apresentacao> getApresentacao() {
		return apresentacao;
	}
	public void setApresentacao(List<Apresentacao> apresentacao) {
		this.apresentacao = apresentacao;
	}
	public String getNomeKata() {
		return nomeKata;
	}
	public void setNomeKata(String nomeKata) {
		this.nomeKata = nomeKata;
	}
	public int getPassos() {
		return passos;
	}
	public void setPassos(int passos) {
		this.passos = passos;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idKata;
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
		Kata other = (Kata) obj;
		if (idKata != other.idKata)
			return false;
		return true;
	}
	
}
