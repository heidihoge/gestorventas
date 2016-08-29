/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is2.venta;

import is2.Clientes;
import is2.ClientesFacade;
import is2.Productos;
import is2.ProductosFacade;
import is2.Vendedores;
import is2.VendedoresFacade;
import is2.VentasDetalle;
import is2.VentasFacade;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author ADMIN
 */
@Named("agregarVentasController")
@SessionScoped
public class AgregarVentaController implements Serializable{
    private String fechaVenta;
    private String idCliente;
    private String idVendedor;
    private Productos producto;
    private int cantidad;
    private List<VentasDetalle> detalles;

    public List<VentasDetalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<VentasDetalle> detalles) {
        this.detalles = detalles;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    public String getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(String idVendedor) {
        this.idVendedor = idVendedor;
    }
    
    @EJB
    VentasFacade ventasFacade;
    
    @EJB
    ClientesFacade clientesFacade;
    
    @EJB
    VendedoresFacade vendedoresFacade;
    
    @EJB
    ProductosFacade productosFacade;
            

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public List<Clientes> getClienteList() {
        return clientesFacade.findAll(); 
    }
    public List<Vendedores> getVendedorList() {
        return vendedoresFacade.findAll(); 
    }
    
    public String getNroVenta() {
        return ventasFacade.getLastId();
    }

    public String getFechaVenta() {
        
        if(fechaVenta == null){
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            fechaVenta = dateFormat.format(date);
        }
        return fechaVenta;
    }
    
    public List<Productos> getProductos(){
        return productosFacade.findAll();
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
    
    public void agregarProducto(){
        
    }
    
    
}
