package util;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import org.omnifaces.converter.SelectItemsConverter;
import entity.Karateca;
@FacesConverter("karatecaConverter")
public class KaratecaConverter extends SelectItemsConverter {
	public String getAsString(FacesContext context, UIComponent component, Object value) {
        String id = (value instanceof Karateca) ? ((Karateca) value).getCpf() : null;
        return (id != null) ? String.valueOf(id) : null;
    }
}