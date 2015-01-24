package util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import org.omnifaces.converter.SelectItemsConverter;
import entity.Apresentacao;
@FacesConverter("apresentacaoConverter")
public class ApresentacaoConverter extends SelectItemsConverter {
	public String getAsString(FacesContext context, UIComponent component, Object value) {
        Integer id = (value instanceof Apresentacao) ? ((Apresentacao) value).getIdApresenta() : null;
        return (id != null) ? String.valueOf(id) : null;
    }
}
