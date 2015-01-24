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
public class Categoria {
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
      private int idCategoria;
	  @Column
      private String nome;
	  @Column
      private int min;
	  @Column
      private int max;
	  @Column
      private String faixa;
      @ManyToOne
      @JoinColumn(referencedColumnName="idEvento",name="fkCompeticao")
      private Competicao competicao;
      @OneToMany(mappedBy="categoria")
      private List<Karateca> karateca;
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public String getFaixa() {
		return faixa;
	}
	public void setFaixa(String faixa) {
		this.faixa = faixa;
	}
	public Competicao getCompeticao() {
		return competicao;
	}
	public void setCompeticao(Competicao competicao) {
		this.competicao = competicao;
	}
	public List<Karateca> getKarateca() {
		return karateca;
	}
	public void setKarateca(List<Karateca> karateca) {
		this.karateca = karateca;
	}
      
}
