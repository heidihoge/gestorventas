/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is2;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "ventas_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VentasDetalle.findAll", query = "SELECT v FROM VentasDetalle v"),
    @NamedQuery(name = "VentasDetalle.findByIdProducto", query = "SELECT v FROM VentasDetalle v WHERE v.idProducto = :idProducto"),
    @NamedQuery(name = "VentasDetalle.findByImporteBruto", query = "SELECT v FROM VentasDetalle v WHERE v.importeBruto = :importeBruto"),
    @NamedQuery(name = "VentasDetalle.findByMontoIva", query = "SELECT v FROM VentasDetalle v WHERE v.montoIva = :montoIva"),
    @NamedQuery(name = "VentasDetalle.findById", query = "SELECT v FROM VentasDetalle v WHERE v.id = :id")})
public class VentasDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_producto")
    private BigInteger idProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "importe_bruto")
    private BigInteger importeBruto;
    @Column(name = "monto_iva")
    private BigInteger montoIva;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private BigDecimal id;
    @JoinColumn(name = "nro_factura", referencedColumnName = "nro_factura")
    @ManyToOne(optional = false)
    private Ventas nroFactura;

    public VentasDetalle() {
    }

    public VentasDetalle(BigDecimal id) {
        this.id = id;
    }

    public VentasDetalle(BigDecimal id, BigInteger idProducto, BigInteger importeBruto) {
        this.id = id;
        this.idProducto = idProducto;
        this.importeBruto = importeBruto;
    }

    public BigInteger getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(BigInteger idProducto) {
        this.idProducto = idProducto;
    }

    public BigInteger getImporteBruto() {
        return importeBruto;
    }

    public void setImporteBruto(BigInteger importeBruto) {
        this.importeBruto = importeBruto;
    }

    public BigInteger getMontoIva() {
        return montoIva;
    }

    public void setMontoIva(BigInteger montoIva) {
        this.montoIva = montoIva;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Ventas getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(Ventas nroFactura) {
        this.nroFactura = nroFactura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentasDetalle)) {
            return false;
        }
        VentasDetalle other = (VentasDetalle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "is2.VentasDetalle[ id=" + id + " ]";
    }
    
}
