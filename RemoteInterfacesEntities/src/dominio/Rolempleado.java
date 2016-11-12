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
@Table(name = "ROLEMPLEADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rolempleado.findAll", query = "SELECT r FROM Rolempleado r")
    , @NamedQuery(name = "Rolempleado.findByIdrol", query = "SELECT r FROM Rolempleado r WHERE r.idrol = :idrol")
    , @NamedQuery(name = "Rolempleado.findByNombrerol", query = "SELECT r FROM Rolempleado r WHERE r.nombrerol = :nombrerol")})
public class Rolempleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDROL")
    private Short idrol;
    @Basic(optional = false)
    @Column(name = "NOMBREROL")
    private String nombrerol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rol", fetch = FetchType.EAGER)
    private List<Empleado> empleadoList;

    public Rolempleado() {
    }

    public Rolempleado(Short idrol) {
        this.idrol = idrol;
    }

    public Rolempleado(Short idrol, String nombrerol) {
        this.idrol = idrol;
        this.nombrerol = nombrerol;
    }

    public Short getIdrol() {
        return idrol;
    }

    public void setIdrol(Short idrol) {
        this.idrol = idrol;
    }

    public String getNombrerol() {
        return nombrerol;
    }

    public void setNombrerol(String nombrerol) {
        this.nombrerol = nombrerol;
    }

    @XmlTransient
    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrol != null ? idrol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rolempleado)) {
            return false;
        }
        Rolempleado other = (Rolempleado) object;
        if ((this.idrol == null && other.idrol != null) || (this.idrol != null && !this.idrol.equals(other.idrol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.Rolempleado[ idrol=" + idrol + " ]";
    }
    
}
