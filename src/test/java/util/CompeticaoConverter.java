package util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import org.omnifaces.converter.SelectItemsConverter;
import entity.Competicao;
@FacesConverter("competicaoConverter")
public class CompeticaoConverter extends SelectItemsConverter {
	public String getAsString(FacesContext context, UIComponent component, Object value) {
        Integer id = (value instanceof Competicao) ? ((Competicao) value).getIdEvento() : null;
        return (id != null) ? String.valueOf(id) : null;
    }
}
