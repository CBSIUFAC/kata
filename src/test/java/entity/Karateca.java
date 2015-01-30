package entity;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import util.Utis;
@Entity
public class Karateca implements Serializable{
   @Id
   private String cpf;
   @Column(nullable=false)
   private String nome;
   @Column
   private Date dataNasc;
   @Column
   private char sexo;
   @Column
   private int faixa;
   @Column
   private int idade;
   @ManyToOne
   @JoinColumn(referencedColumnName="idDojo",name="fkDojo")
   private Dojo dojo;
   @ManyToOne
   @JoinColumn(referencedColumnName="idCategoria",name="fkCategoria")
   private Categoria categoria;
   @OneToMany(mappedBy="karateca")
   private List<Apresentacao> apresentacao;
   public List<Apresentacao> getApresentacao() {
		return apresentacao;
	}
  public String getCpf() {
	return cpf;
  }
  public void setCpf(String cpf) {
	this.cpf = cpf;
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
	  Utis cal = new Utis();
	  this.idade = cal.calculaIdade(dataNasc);
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
  public void setCategoria(Categoria categoria) {
	this.categoria = categoria;
  }
  
  public Categoria getCategoria() {
	return categoria;
  }
  public Dojo getDojo() {
 	return dojo;
  }
  public void setDojo(Dojo dojo) {
	this.dojo = dojo;
  }
  public void setApresentacao(List<Apresentacao> apresentacao) {
	this.apresentacao = apresentacao;
  }
  public int getIdade() {
	return idade;
}
public void setIdade(int idade) {
	this.idade = idade;
}
@Override
  public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
	Karateca other = (Karateca) obj;
	if (cpf == null) {
		if (other.cpf != null)
			return false;
	} else if (!cpf.equals(other.cpf))
		return false;
	return true;
  }  
}
