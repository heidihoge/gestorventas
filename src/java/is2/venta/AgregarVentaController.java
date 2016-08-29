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
import is2.Ventas;
import is2.VentasDetalle;
import is2.VentasFacade;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
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

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(String idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }
    private Clientes cliente;
    private String idVendedor;
    private Vendedores vendedor;
    private String idProducto;
    private Productos producto;
    private VentasDetalle seleccionado;
    private Ventas venta;

    @PostConstruct
    public void initialize(){
        venta = new Ventas();
        venta.setFecha(new Date());
        venta.setNroFactura(BigDecimal.valueOf(Integer.valueOf(getNroVenta())));
        venta.setVentasDetalleCollection(detalles);
    }
    
    public VentasDetalle getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(VentasDetalle seleccionado) {
        this.seleccionado = seleccionado;
    }
    private int cantidad;
    private List<VentasDetalle> detalles = new ArrayList<>();

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

    public Vendedores getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedores vendedor) {
        venta.setIdVendedor(vendedor);
        this.vendedor = vendedor;
    }
    
    @EJB
    VentasFacade ventasFacade;
    
    @EJB
    ClientesFacade clientesFacade;
    
    @EJB
    VendedoresFacade vendedoresFacade;
    
    @EJB
    ProductosFacade productosFacade;
            

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        venta.setIdCliente(cliente);
        this.cliente = cliente;
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
    
    public void agregarProducto(ActionEvent event){
        VentasDetalle nuevoDetalle = new VentasDetalle();
        nuevoDetalle.setIdProducto(producto);
        nuevoDetalle.setImporteBruto(producto.getPrecioUnitario().multiply(BigInteger.valueOf(cantidad)));
        nuevoDetalle.setMontoIva(producto.getPrecioUnitario()
                    .multiply(BigInteger.valueOf(cantidad))
                    .multiply(BigInteger.valueOf(producto.getIva()))
                    .divide(BigInteger.valueOf(100)));
        nuevoDetalle.setNroFactura(venta);
        nuevoDetalle.setCantidad(BigInteger.valueOf(cantidad));
        
        Integer totalIva = venta.getTotalIva();
        totalIva += producto.getPrecioUnitario().intValue() * cantidad * producto.getIva() / 100;
        Integer totalVenta = venta.getTotalVenta();
        totalVenta += producto.getPrecioUnitario().intValue() * cantidad;
        
        venta.setTotalIva(totalIva);
        venta.setTotalVenta(totalVenta);
        
        detalles.add(nuevoDetalle);
    }
    
    
}
