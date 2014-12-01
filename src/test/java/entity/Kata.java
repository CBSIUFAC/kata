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
	public int getKata() {
		return idKata;
	}
	public void setKata(int kata) {
		this.idKata = kata;
	}
	public String getNomeKata() {
		return nomeKata;
	}
	public void setNomeKata(String nomeKata) {
		this.nomeKata = nomeKata;
	}
	public int getPasos() {
		return passos;
	}
	public void setPasos(int pasos) {
		this.passos = pasos;
	}
	
}
