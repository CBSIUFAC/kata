package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Dojo implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
   private int idDojo ;
	@Column(nullable=false)
   private String nomeDojo ;
	@OneToMany(mappedBy="dojo")
	  private List<Karateca> karatecas;
	
	public List<Karateca> getKaratecas() {
		return karatecas;
	}
   public int getIdDojo() {
	return idDojo;
   }
   public void setIdDojo(int idDojo) {
	this.idDojo = idDojo;
   }
   public String getNomeDojo() {
	return nomeDojo;
   }
   public void setNomeDojo(String nomeDojo) {
	this.nomeDojo = nomeDojo;
   }
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + idDojo;
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
	Dojo other = (Dojo) obj;
	if (idDojo != other.idDojo)
		return false;
	return true;
}
}
