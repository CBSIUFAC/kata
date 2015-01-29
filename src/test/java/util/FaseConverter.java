package util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import org.omnifaces.converter.SelectItemsConverter;
import entity.Fase;
@FacesConverter("faseConverter")
public class FaseConverter extends SelectItemsConverter {
	public String getAsString(FacesContext context, UIComponent component, Object value) {
        Integer id = (value instanceof Fase) ? ((Fase) value).getIdFase() : null;
        return (id != null) ? String.valueOf(id) : null;
    }
}
