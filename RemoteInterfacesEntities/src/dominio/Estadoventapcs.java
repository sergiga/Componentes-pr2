/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sergio
 */
@Entity
@Table(name = "ESTADOVENTAPCS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadoventapcs.findAll", query = "SELECT e FROM Estadoventapcs e")
    , @NamedQuery(name = "Estadoventapcs.findByIdestadoventa", query = "SELECT e FROM Estadoventapcs e WHERE e.idestadoventa = :idestadoventa")
    , @NamedQuery(name = "Estadoventapcs.findByNombreestadoventa", query = "SELECT e FROM Estadoventapcs e WHERE e.nombreestadoventa = :nombreestadoventa")})
public class Estadoventapcs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDESTADOVENTA")
    private Short idestadoventa;
    @Basic(optional = false)
    @Column(name = "NOMBREESTADOVENTA")
    private String nombreestadoventa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estado", fetch = FetchType.EAGER)
    private List<Pedidopc> pedidopcList;

    public Estadoventapcs() {
    }

    public Estadoventapcs(Short idestadoventa) {
        this.idestadoventa = idestadoventa;
    }

    public Estadoventapcs(Short idestadoventa, String nombreestadoventa) {
        this.idestadoventa = idestadoventa;
        this.nombreestadoventa = nombreestadoventa;
    }

    public Short getIdestadoventa() {
        return idestadoventa;
    }

    public void setIdestadoventa(Short idestadoventa) {
        this.idestadoventa = idestadoventa;
    }

    public String getNombreestadoventa() {
        return nombreestadoventa;
    }

    public void setNombreestadoventa(String nombreestadoventa) {
        this.nombreestadoventa = nombreestadoventa;
    }

    @XmlTransient
    public List<Pedidopc> getPedidopcList() {
        return pedidopcList;
    }

    public void setPedidopcList(List<Pedidopc> pedidopcList) {
        this.pedidopcList = pedidopcList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestadoventa != null ? idestadoventa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadoventapcs)) {
            return false;
        }
        Estadoventapcs other = (Estadoventapcs) object;
        if ((this.idestadoventa == null && other.idestadoventa != null) || (this.idestadoventa != null && !this.idestadoventa.equals(other.idestadoventa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.Estadoventapcs[ idestadoventa=" + idestadoventa + " ]";
    }
    
}
