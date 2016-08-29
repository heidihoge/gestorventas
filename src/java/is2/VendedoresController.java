package is2;

import is2.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
@Named(value="vendedoresController")
@ViewScoped
public class VendedoresController extends AbstractController<Vendedores> {

    @Inject
    private MobilePageController mobilePageController;

    public VendedoresController() {
        // Inform the Abstract parent controller of the concrete Vendedores Entity
        super(Vendedores.class);
    }



    /**
    * Sets the "items" attribute with a collection of Ventas entities that are retrieved from Vendedores?cap_first
     * and returns the navigation outcome.
     *
     * @return  navigation outcome for Ventas page
     */
    public String navigateVentasCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Ventas_items", this.getSelected().getVentasCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/ventas/index";
    }

}
