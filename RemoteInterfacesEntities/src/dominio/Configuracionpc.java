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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "CONFIGURACIONPC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Configuracionpc.findAll", query = "SELECT c FROM Configuracionpc c")
    , @NamedQuery(name = "Configuracionpc.findByIdconfiguracion", query = "SELECT c FROM Configuracionpc c WHERE c.idconfiguracion = :idconfiguracion")
    , @NamedQuery(name = "Configuracionpc.findByVelocidadcpu", query = "SELECT c FROM Configuracionpc c WHERE c.velocidadcpu = :velocidadcpu")
    , @NamedQuery(name = "Configuracionpc.findByCapacidadram", query = "SELECT c FROM Configuracionpc c WHERE c.capacidadram = :capacidadram")
    , @NamedQuery(name = "Configuracionpc.findByCapacidaddd", query = "SELECT c FROM Configuracionpc c WHERE c.capacidaddd = :capacidaddd")
    , @NamedQuery(name = "Configuracionpc.findByVelocidadtarjetagrafica", query = "SELECT c FROM Configuracionpc c WHERE c.velocidadtarjetagrafica = :velocidadtarjetagrafica")
    , @NamedQuery(name = "Configuracionpc.findByMemoriatarjetagrafica", query = "SELECT c FROM Configuracionpc c WHERE c.memoriatarjetagrafica = :memoriatarjetagrafica")})
public class Configuracionpc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDCONFIGURACION")
    private Integer idconfiguracion;
    @Basic(optional = false)
    @Column(name = "VELOCIDADCPU")
    private double velocidadcpu;
    @Basic(optional = false)
    @Column(name = "CAPACIDADRAM")
    private int capacidadram;
    @Basic(optional = false)
    @Column(name = "CAPACIDADDD")
    private int capacidaddd;
    @Column(name = "VELOCIDADTARJETAGRAFICA")
    private double velocidadtarjetagrafica;
    @Column(name = "MEMORIATARJETAGRAFICA")
    private Integer memoriatarjetagrafica;
    @JoinTable(name = "COMPONENTESENCONFIGURACION", joinColumns = {
        @JoinColumn(name = "IDCONFIGURACION", referencedColumnName = "IDCONFIGURACION")}, inverseJoinColumns = {
        @JoinColumn(name = "IDDESCRIPCION", referencedColumnName = "IDDESCRIPCION")})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Descripcioncomponente> descripcioncomponenteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "configuracionsolicitada", fetch = FetchType.EAGER)
    private List<Pedidopc> pedidopcList;
    @JoinColumn(name = "TIPOCPU", referencedColumnName = "IDTIPOCPU")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Cpu tipocpu;

    public Configuracionpc() {
    }

    public Configuracionpc(Integer idconfiguracion) {
        this.idconfiguracion = idconfiguracion;
    }

    public Configuracionpc(Integer idconfiguracion, int velocidadcpu, int capacidadram, int capacidaddd) {
        this.idconfiguracion = idconfiguracion;
        this.velocidadcpu = velocidadcpu;
        this.capacidadram = capacidadram;
        this.capacidaddd = capacidaddd;
    }

    public Integer getIdconfiguracion() {
        return idconfiguracion;
    }

    public void setIdconfiguracion(Integer idconfiguracion) {
        this.idconfiguracion = idconfiguracion;
    }

    public double getVelocidadcpu() {
        return velocidadcpu;
    }

    public void setVelocidadcpu(double velocidadcpu) {
        this.velocidadcpu = velocidadcpu;
    }

    public int getCapacidadram() {
        return capacidadram;
    }

    public void setCapacidadram(int capacidadram) {
        this.capacidadram = capacidadram;
    }

    public int getCapacidaddd() {
        return capacidaddd;
    }

    public void setCapacidaddd(int capacidaddd) {
        this.capacidaddd = capacidaddd;
    }

    public double getVelocidadtarjetagrafica() {
        return velocidadtarjetagrafica;
    }

    public void setVelocidadtarjetagrafica(double velocidadtarjetagrafica) {
        this.velocidadtarjetagrafica = velocidadtarjetagrafica;
    }

    public Integer getMemoriatarjetagrafica() {
        return memoriatarjetagrafica;
    }

    public void setMemoriatarjetagrafica(Integer memoriatarjetagrafica) {
        this.memoriatarjetagrafica = memoriatarjetagrafica;
    }

    @XmlTransient
    public List<Descripcioncomponente> getDescripcioncomponenteList() {
        return descripcioncomponenteList;
    }

    public void setDescripcioncomponenteList(List<Descripcioncomponente> descripcioncomponenteList) {
        this.descripcioncomponenteList = descripcioncomponenteList;
    }

    @XmlTransient
    public List<Pedidopc> getPedidopcList() {
        return pedidopcList;
    }

    public void setPedidopcList(List<Pedidopc> pedidopcList) {
        this.pedidopcList = pedidopcList;
    }

    public Cpu getTipocpu() {
        return tipocpu;
    }

    public void setTipocpu(Cpu tipocpu) {
        this.tipocpu = tipocpu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idconfiguracion != null ? idconfiguracion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Configuracionpc)) {
            return false;
        }
        Configuracionpc other = (Configuracionpc) object;
        if ((this.idconfiguracion == null && other.idconfiguracion != null) || (this.idconfiguracion != null && !this.idconfiguracion.equals(other.idconfiguracion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.Configuracionpc[ idconfiguracion=" + idconfiguracion + " ]";
    }
    
}
