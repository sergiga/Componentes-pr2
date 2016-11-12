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
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sergio
 */
@Entity
@Table(name = "EMPRESA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e")
    , @NamedQuery(name = "Empresa.findByNifcif", query = "SELECT e FROM Empresa e WHERE e.nifcif = :nifcif")
    , @NamedQuery(name = "Empresa.findByEscliente", query = "SELECT e FROM Empresa e WHERE e.escliente = :escliente")
    , @NamedQuery(name = "Empresa.findByEsproveedor", query = "SELECT e FROM Empresa e WHERE e.esproveedor = :esproveedor")})
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NIFCIF")
    private String nifcif;
    @Column(name = "ESCLIENTE")
    private Short escliente;
    @Column(name = "ESPROVEEDOR")
    private Short esproveedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "encargadopor", fetch = FetchType.EAGER)
    private List<Pedidopc> pedidopcList;
    @JoinColumn(name = "NIFCIF", referencedColumnName = "NIFCIF", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuario;

    public Empresa() {
    }

    public Empresa(String nifcif) {
        this.nifcif = nifcif;
    }

    public String getNifcif() {
        return nifcif;
    }

    public void setNifcif(String nifcif) {
        this.nifcif = nifcif;
    }

    public Short getEscliente() {
        return escliente;
    }

    public void setEscliente(Short escliente) {
        this.escliente = escliente;
    }

    public Short getEsproveedor() {
        return esproveedor;
    }

    public void setEsproveedor(Short esproveedor) {
        this.esproveedor = esproveedor;
    }

    @XmlTransient
    public List<Pedidopc> getPedidopcList() {
        return pedidopcList;
    }

    public void setPedidopcList(List<Pedidopc> pedidopcList) {
        this.pedidopcList = pedidopcList;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nifcif != null ? nifcif.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.nifcif == null && other.nifcif != null) || (this.nifcif != null && !this.nifcif.equals(other.nifcif))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.Empresa[ nifcif=" + nifcif + " ]";
    }
    
}
