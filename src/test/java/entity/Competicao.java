package entity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@OneToMany(mappedBy="competicao")
	private List<Categoria> categoria;
	@Column
	private Date data;
	@OneToMany(mappedBy="competicao")
	private List<Fase> fase;
	public int getIdEvento() {
		return idEvento;
	}
	@Column
	private String competicaoSel;
	public String getCompeticaoSel() {
		return competicaoSel;
	}
	public void setCompeticaoSel(String competicaoSel) {
		this.competicaoSel = competicaoSel;
	}
	@OneToMany(mappedBy="competicao", fetch = FetchType.EAGER)
	private List<Apresentacao> apresentacao;
	
	public List<Apresentacao> getApresentacao() {
		return apresentacao;
	}
	public void setApresentacao(List<Apresentacao> apresentacao) {
		this.apresentacao = apresentacao;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idEvento;
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
		Competicao other = (Competicao) obj;
		if (idEvento != other.idEvento)
			return false;
		return true;
	}
	public List<Categoria> getCategoria() {
		return categoria;
	}
	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}


}
