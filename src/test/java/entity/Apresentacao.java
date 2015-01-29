package entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.lowagie.toolbox.plugins.Concat;

import manageBean.AvaliacaoBean;
@Entity
public class Apresentacao{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int idApresenta;
	
	@Column
    private float pontuacao;
	
	@Column
	private String NomeApresenta;
    
	public String getNomeApresenta() {
		return NomeApresenta;
	}
	public void setNomeApresenta(String nomeApresenta) {
		this.NomeApresenta = nomeApresenta;
	}
	@ManyToOne
	@JoinColumn(referencedColumnName="cpf",name="fKCpf")
	private Karateca karateca;
    
    @ManyToOne
	@JoinColumn(referencedColumnName="idKata",name="fKata")
	private Kata kata;
    
    @ManyToOne
   	@JoinColumn(referencedColumnName="idFase",name="fkFase")
   	private Fase fase;
    
    @OneToMany(mappedBy="apresentacao", fetch = FetchType.EAGER)
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idApresenta;
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
		Apresentacao other = (Apresentacao) obj;
		if (idApresenta != other.idApresenta)
			return false;
		return true;
	}
    
}
