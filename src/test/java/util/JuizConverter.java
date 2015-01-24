package util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

import org.omnifaces.converter.SelectItemsConverter;

import entity.Juiz;
@FacesConverter("juizConverter")
public class JuizConverter extends SelectItemsConverter {
	public String getAsString(FacesContext context, UIComponent component, Object value) {
        Integer id = (value instanceof Juiz) ? ((Juiz) value).getIdJuiz() : null;
        return (id != null) ? String.valueOf(id) : null;
    }
}
