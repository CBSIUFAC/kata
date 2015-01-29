package util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import org.omnifaces.converter.SelectItemsConverter;
import entity.Kata;
@FacesConverter("kataConverter")
public class KataConverter extends SelectItemsConverter {
	public String getAsString(FacesContext context, UIComponent component, Object value) {
        Integer id = (value instanceof Kata) ? ((Kata) value).getIdKata() : null;
        return (id != null) ? String.valueOf(id) : null;
    }
}
