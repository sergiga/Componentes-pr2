
package webservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para addConfiguracion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="addConfiguracion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="velCPU" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="capRAM" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="capDD" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="velTarGraf" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="memTarGraf" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idTipoCPU" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="idsDescrComp" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addConfiguracion", propOrder = {
    "velCPU",
    "capRAM",
    "capDD",
    "velTarGraf",
    "memTarGraf",
    "idTipoCPU",
    "idsDescrComp"
})
public class AddConfiguracion {

    protected double velCPU;
    protected int capRAM;
    protected int capDD;
    protected double velTarGraf;
    protected int memTarGraf;
    protected short idTipoCPU;
    @XmlElement(type = Integer.class)
    protected List<Integer> idsDescrComp;

    /**
     * Obtiene el valor de la propiedad velCPU.
     * 
     */
    public double getVelCPU() {
        return velCPU;
    }

    /**
     * Define el valor de la propiedad velCPU.
     * 
     */
    public void setVelCPU(double value) {
        this.velCPU = value;
    }

    /**
     * Obtiene el valor de la propiedad capRAM.
     * 
     */
    public int getCapRAM() {
        return capRAM;
    }

    /**
     * Define el valor de la propiedad capRAM.
     * 
     */
    public void setCapRAM(int value) {
        this.capRAM = value;
    }

    /**
     * Obtiene el valor de la propiedad capDD.
     * 
     */
    public int getCapDD() {
        return capDD;
    }

    /**
     * Define el valor de la propiedad capDD.
     * 
     */
    public void setCapDD(int value) {
        this.capDD = value;
    }

    /**
     * Obtiene el valor de la propiedad velTarGraf.
     * 
     */
    public double getVelTarGraf() {
        return velTarGraf;
    }

    /**
     * Define el valor de la propiedad velTarGraf.
     * 
     */
    public void setVelTarGraf(double value) {
        this.velTarGraf = value;
    }

    /**
     * Obtiene el valor de la propiedad memTarGraf.
     * 
     */
    public int getMemTarGraf() {
        return memTarGraf;
    }

    /**
     * Define el valor de la propiedad memTarGraf.
     * 
     */
    public void setMemTarGraf(int value) {
        this.memTarGraf = value;
    }

    /**
     * Obtiene el valor de la propiedad idTipoCPU.
     * 
     */
    public short getIdTipoCPU() {
        return idTipoCPU;
    }

    /**
     * Define el valor de la propiedad idTipoCPU.
     * 
     */
    public void setIdTipoCPU(short value) {
        this.idTipoCPU = value;
    }

    /**
     * Gets the value of the idsDescrComp property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idsDescrComp property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIdsDescrComp().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getIdsDescrComp() {
        if (idsDescrComp == null) {
            idsDescrComp = new ArrayList<Integer>();
        }
        return this.idsDescrComp;
    }

}
