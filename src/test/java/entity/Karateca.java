package entity;

import java.io.Serializable;
import java.util.Date;
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
public class Karateca implements Serializable{
   @Id
   //@GeneratedValue(strategy=GenerationType.AUTO)
   private String rgKarateca;
   @Column(nullable=false)
   private String nome;
   @Column
   private Date dataNasc;
   @Column
   private char sexo;
   @Column
   private int faixa;
   @Column
   private int categoria;
   @ManyToOne
	@JoinColumn(referencedColumnName="idDojo",name="fkDojo")
	private Dojo dojo;
   @OneToMany(mappedBy="karateca")
   private List<Apresentacao> apresentacao;
   public List<Apresentacao> getApresentacao() {
		return apresentacao;
	}
public String getRgKarateca() {
	return rgKarateca;
}
public void setRgKarateca(String rgKarateca) {
	this.rgKarateca = rgKarateca;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public Date getDataNasc() {
	return dataNasc;
}
public void setDataNasc(Date dataNasc) {
	this.dataNasc = dataNasc;
}
public char getSexo() {
	return sexo;
}
public void setSexo(char sexo) {
	this.sexo = sexo;
}
public int getFaixa() {
	return faixa;
}
public void setFaixa(int faixa) {
	this.faixa = faixa;
}
public int getCategoria() {
	return categoria;
}
public void setCategoria(int categoria) {
	this.categoria = categoria;
}
public Dojo getDojo() {
	return dojo;
}
public void setDojo(Dojo dojo) {
	this.dojo = dojo;
}
   
}
