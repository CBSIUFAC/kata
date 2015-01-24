package util;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import org.omnifaces.converter.SelectItemsConverter;
import entity.Categoria;
@FacesConverter("categoriaConverter")
public class CategoriaConverter extends SelectItemsConverter{
	public String getAsString(FacesContext context, UIComponent component, Object value) {
        Integer id = (value instanceof Categoria) ? ((Categoria) value).getIdCategoria() : null;
        return (id != null) ? String.valueOf(id) : null;
    }
}
