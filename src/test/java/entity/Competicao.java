package entity;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Competicao {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idEvento;
	@Column
    private String nomeEvento;
	@Column
    private String organizador;
	public int getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}
	public List<Fase> getFase() {
		return fase;
	}
	public void setFase(List<Fase> fase) {
		this.fase = fase;
	}
	@Column
    private Date data;
	@OneToMany(mappedBy="competicao")
	  private List<Fase> fase;
	public String getNomeEvento() {
		return nomeEvento;
	}
	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}
	public String getOrganizador() {
		return organizador;
	}
	public void setOrganizador(String organizador) {
		this.organizador = organizador;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
}