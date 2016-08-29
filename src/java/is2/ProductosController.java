package is2;

import is2.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "productosController")
@ViewScoped
public class ProductosController extends AbstractController<Productos> {

    @Inject
    private MobilePageController mobilePageController;

    public ProductosController() {
        // Inform the Abstract parent controller of the concrete Productos Entity
        super(Productos.class);
    }

}
