/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is2;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ADMIN
 */
@Stateless
public class VentasFacade extends AbstractFacade<Ventas> {

    @PersistenceContext(unitName = "gestorVentasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public String getLastId(){
        try{
            Query getLastId = em.createNativeQuery("Select nro_factura + 1 from ventas order"
                    + " by nro_factura desc limit 1");
            Object singleResult = getLastId.getSingleResult();
            return singleResult.toString();
        }catch(Exception ex){
            return "1";
        }
    }

    public VentasFacade() {
        super(Ventas.class);
    }
    
}
