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
   private String faixa;
   @Column
   private String categoria;
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
public String getDataNasc(){  
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    
	return sdf.format(dataNasc);
}
public void setDataNasc(String dataNasci) throws ParseException {  
	SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
	this.dataNasc = sdf.parse(dataNasci);
}
public char getSexo() {
	return sexo;
}
public void setSexo(char sexo) {
	this.sexo = sexo;
}
public String getFaixa() {
	return faixa;
}
public void setFaixa(String faixa) {
	this.faixa = faixa;
}
public String getCategoria() {
	return categoria;
}
public void setCategoria(String categoria) {
	this.categoria = categoria;
}
public Dojo getDojo() {
	return dojo;
}
public void setDojo(Dojo dojo) {
	this.dojo = dojo;
}
   
}
