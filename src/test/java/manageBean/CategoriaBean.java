package manageBean;

import java.util.List;



import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import DAO.CategoriaDAO;
import entity.Categoria;
@ManagedBean(name="categoriaBean")
@SessionScoped
public class CategoriaBean {
	private Categoria categoria;
    private CategoriaDAO categoriaDAO= new CategoriaDAO();
    public void prepararK(){
		categoria = new Categoria();
	}
    public String inserirCategoria(){
		categoriaDAO.inserirCategoria(categoria);
		listaCategoria = null;
		return "listacategorias";
	}
    public Categoria getCategoria() {
		if(categoria == null)
			categoria = new Categoria();
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	private List<Categoria> listaCategoria =null;
	private List<Categoria> filtroLista = null;
	
	public List<Categoria> getListaCategorias(){
		if(listaCategoria == null)
			listaCategoria = categoriaDAO.listarCategoria();
		return listaCategoria;
	}
	
	public List<Categoria> getFiltroLista() {
		return filtroLista;
	}
	public void setFiltroLista(List<Categoria> filtroLista) {
		this.filtroLista = filtroLista;
	}
	public String deletarCategoria(){
		categoriaDAO.deletarCategoria(categoria);
		listaCategoria = null;
		return "listacategorias";
	}
	public void atualizarCategoria(RowEditEvent evento){
		categoria = (Categoria)evento.getObject();
		categoriaDAO.atualizarCategoria(categoria);
	}
	
	public void cancelarCategoria(RowEditEvent evento){
		FacesMessage msg = new FacesMessage("Edição Cancelada");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}
