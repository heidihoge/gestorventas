/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is2;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "ventas_detalle", catalog = "ventas", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VentasDetalle.findAll", query = "SELECT v FROM VentasDetalle v"),
    @NamedQuery(name = "VentasDetalle.findByIdProducto", query = "SELECT v FROM VentasDetalle v WHERE v.ventasDetallePK.idProducto = :idProducto"),
    @NamedQuery(name = "VentasDetalle.findByCodigo", query = "SELECT v FROM VentasDetalle v WHERE v.ventasDetallePK.codigo = :codigo"),
    @NamedQuery(name = "VentasDetalle.findByFactura", query = "SELECT v FROM VentasDetalle v WHERE v.factura = :factura"),
    @NamedQuery(name = "VentasDetalle.findByImporteBruto", query = "SELECT v FROM VentasDetalle v WHERE v.importeBruto = :importeBruto"),
    @NamedQuery(name = "VentasDetalle.findByMontoIva", query = "SELECT v FROM VentasDetalle v WHERE v.montoIva = :montoIva")})
public class VentasDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VentasDetallePK ventasDetallePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "factura")
    private BigInteger factura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "importe_bruto")
    private BigInteger importeBruto;
    @Column(name = "monto_iva")
    private BigInteger montoIva;

    public VentasDetalle() {
    }

    public VentasDetalle(VentasDetallePK ventasDetallePK) {
        this.ventasDetallePK = ventasDetallePK;
    }

    public VentasDetalle(VentasDetallePK ventasDetallePK, BigInteger factura, BigInteger importeBruto) {
        this.ventasDetallePK = ventasDetallePK;
        this.factura = factura;
        this.importeBruto = importeBruto;
    }

    public VentasDetalle(BigInteger idProducto, BigInteger codigo) {
        this.ventasDetallePK = new VentasDetallePK(idProducto, codigo);
    }

    public VentasDetallePK getVentasDetallePK() {
        return ventasDetallePK;
    }

    public void setVentasDetallePK(VentasDetallePK ventasDetallePK) {
        this.ventasDetallePK = ventasDetallePK;
    }

    public BigInteger getFactura() {
        return factura;
    }

    public void setFactura(BigInteger factura) {
        this.factura = factura;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ventasDetallePK != null ? ventasDetallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentasDetalle)) {
            return false;
        }
        VentasDetalle other = (VentasDetalle) object;
        if ((this.ventasDetallePK == null && other.ventasDetallePK != null) || (this.ventasDetallePK != null && !this.ventasDetallePK.equals(other.ventasDetallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "is2.VentasDetalle[ ventasDetallePK=" + ventasDetallePK + " ]";
    }
    
}
