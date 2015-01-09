package util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import org.omnifaces.converter.SelectItemsConverter;
import entity.Dojo;
@FacesConverter("dojoConverter")
public class DojoConverter extends SelectItemsConverter {
	public String getAsString(FacesContext context, UIComponent component, Object value) {
        Integer id = (value instanceof Dojo) ? ((Dojo) value).getIdDojo() : null;
        return (id != null) ? String.valueOf(id) : null;
    }
}
