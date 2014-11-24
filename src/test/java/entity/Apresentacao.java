package entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Apresentacao {
	@Id
    private int idApresenta;
	@Column
    private float pontuacao;
    @ManyToOne
	@JoinColumn(referencedColumnName="rgKarateca",name="fKarateca")
	private Karateca karateca;
    @ManyToOne
	@JoinColumn(referencedColumnName="idKata",name="fKata")
	private Kata kata;
    @ManyToOne
   	@JoinColumn(referencedColumnName="idFase",name="fkFase")
   	private Fase fase;
    @OneToMany(mappedBy="apresentacao")
    private List<Avaliacao> avaliacao;
	public int getIdApresenta() {
		return idApresenta;
	}
	public void setIdApresenta(int idApresenta) {
		this.idApresenta = idApresenta;
	}
	public float getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(float pontuacao) {
		this.pontuacao = pontuacao;
	}
	public Karateca getKarateca() {
		return karateca;
	}
	public void setKarateca(Karateca karateca) {
		this.karateca = karateca;
	}
	public Kata getKata() {
		return kata;
	}
	public void setKata(Kata kata) {
		this.kata = kata;
	}
	public Fase getFase() {
		return fase;
	}
	public void setFase(Fase fase) {
		this.fase = fase;
	}
	public List<Avaliacao> getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(List<Avaliacao> avaliacao) {
		this.avaliacao = avaliacao;
	}
    
}