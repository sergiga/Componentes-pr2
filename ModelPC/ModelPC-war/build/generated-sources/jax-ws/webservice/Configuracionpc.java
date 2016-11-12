
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para configuracionpc complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="configuracionpc">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="capacidaddd" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="capacidadram" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idconfiguracion" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="memoriatarjetagrafica" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="tipocpu" type="{http://webservice/}cpu" minOccurs="0"/>
 *         &lt;element name="velocidadcpu" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="velocidadtarjetagrafica" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "configuracionpc", propOrder = {
    "capacidaddd",
    "capacidadram",
    "idconfiguracion",
    "memoriatarjetagrafica",
    "tipocpu",
    "velocidadcpu",
    "velocidadtarjetagrafica"
})
public class Configuracionpc {

    protected int capacidaddd;
    protected int capacidadram;
    protected Integer idconfiguracion;
    protected Integer memoriatarjetagrafica;
    protected Cpu tipocpu;
    protected double velocidadcpu;
    protected double velocidadtarjetagrafica;

    /**
     * Obtiene el valor de la propiedad capacidaddd.
     * 
     */
    public int getCapacidaddd() {
        return capacidaddd;
    }

    /**
     * Define el valor de la propiedad capacidaddd.
     * 
     */
    public void setCapacidaddd(int value) {
        this.capacidaddd = value;
    }

    /**
     * Obtiene el valor de la propiedad capacidadram.
     * 
     */
    public int getCapacidadram() {
        return capacidadram;
    }

    /**
     * Define el valor de la propiedad capacidadram.
     * 
     */
    public void setCapacidadram(int value) {
        this.capacidadram = value;
    }

    /**
     * Obtiene el valor de la propiedad idconfiguracion.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdconfiguracion() {
        return idconfiguracion;
    }

    /**
     * Define el valor de la propiedad idconfiguracion.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdconfiguracion(Integer value) {
        this.idconfiguracion = value;
    }

    /**
     * Obtiene el valor de la propiedad memoriatarjetagrafica.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMemoriatarjetagrafica() {
        return memoriatarjetagrafica;
    }

    /**
     * Define el valor de la propiedad memoriatarjetagrafica.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMemoriatarjetagrafica(Integer value) {
        this.memoriatarjetagrafica = value;
    }

    /**
     * Obtiene el valor de la propiedad tipocpu.
     * 
     * @return
     *     possible object is
     *     {@link Cpu }
     *     
     */
    public Cpu getTipocpu() {
        return tipocpu;
    }

    /**
     * Define el valor de la propiedad tipocpu.
     * 
     * @param value
     *     allowed object is
     *     {@link Cpu }
     *     
     */
    public void setTipocpu(Cpu value) {
        this.tipocpu = value;
    }

    /**
     * Obtiene el valor de la propiedad velocidadcpu.
     * 
     */
    public double getVelocidadcpu() {
        return velocidadcpu;
    }

    /**
     * Define el valor de la propiedad velocidadcpu.
     * 
     */
    public void setVelocidadcpu(double value) {
        this.velocidadcpu = value;
    }

    /**
     * Obtiene el valor de la propiedad velocidadtarjetagrafica.
     * 
     */
    public double getVelocidadtarjetagrafica() {
        return velocidadtarjetagrafica;
    }

    /**
     * Define el valor de la propiedad velocidadtarjetagrafica.
     * 
     */
    public void setVelocidadtarjetagrafica(double value) {
        this.velocidadtarjetagrafica = value;
    }

}
