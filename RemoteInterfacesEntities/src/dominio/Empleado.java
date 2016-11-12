/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sergio
 */
@Entity
@Table(name = "EMPLEADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")
    , @NamedQuery(name = "Empleado.findByNifcif", query = "SELECT e FROM Empleado e WHERE e.nifcif = :nifcif")
    , @NamedQuery(name = "Empleado.findByFechacontratacion", query = "SELECT e FROM Empleado e WHERE e.fechacontratacion = :fechacontratacion")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NIFCIF")
    private String nifcif;
    @Basic(optional = false)
    @Column(name = "FECHACONTRATACION")
    @Temporal(TemporalType.DATE)
    private Date fechacontratacion;
    @JoinColumn(name = "ROL", referencedColumnName = "IDROL")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Rolempleado rol;
    @JoinColumn(name = "NIFCIF", referencedColumnName = "NIFCIF", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuario;

    public Empleado() {
    }

    public Empleado(String nifcif) {
        this.nifcif = nifcif;
    }

    public Empleado(String nifcif, Date fechacontratacion) {
        this.nifcif = nifcif;
        this.fechacontratacion = fechacontratacion;
    }

    public String getNifcif() {
        return nifcif;
    }

    public void setNifcif(String nifcif) {
        this.nifcif = nifcif;
    }

    public Date getFechacontratacion() {
        return fechacontratacion;
    }

    public void setFechacontratacion(Date fechacontratacion) {
        this.fechacontratacion = fechacontratacion;
    }

    public Rolempleado getRol() {
        return rol;
    }

    public void setRol(Rolempleado rol) {
        this.rol = rol;
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
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.nifcif == null && other.nifcif != null) || (this.nifcif != null && !this.nifcif.equals(other.nifcif))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.Empleado[ nifcif=" + nifcif + " ]";
    }
    
}
