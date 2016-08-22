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
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ADMIN
 */
@Embeddable
public class VentasDetallePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_producto")
    private BigInteger idProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private BigInteger codigo;

    public VentasDetallePK() {
    }

    public VentasDetallePK(BigInteger idProducto, BigInteger codigo) {
        this.idProducto = idProducto;
        this.codigo = codigo;
    }

    public BigInteger getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(BigInteger idProducto) {
        this.idProducto = idProducto;
    }

    public BigInteger getCodigo() {
        return codigo;
    }

    public void setCodigo(BigInteger codigo) {
        this.codigo = codigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentasDetallePK)) {
            return false;
        }
        VentasDetallePK other = (VentasDetallePK) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "is2.VentasDetallePK[ idProducto=" + idProducto + ", codigo=" + codigo + " ]";
    }
    
}
