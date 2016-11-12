
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para cpu complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="cpu">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idtipocpu" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *         &lt;element name="nombretipocpu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cpu", propOrder = {
    "idtipocpu",
    "nombretipocpu"
})
public class Cpu {

    protected Short idtipocpu;
    protected String nombretipocpu;

    /**
     * Obtiene el valor de la propiedad idtipocpu.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getIdtipocpu() {
        return idtipocpu;
    }

    /**
     * Define el valor de la propiedad idtipocpu.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setIdtipocpu(Short value) {
        this.idtipocpu = value;
    }

    /**
     * Obtiene el valor de la propiedad nombretipocpu.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombretipocpu() {
        return nombretipocpu;
    }

    /**
     * Define el valor de la propiedad nombretipocpu.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombretipocpu(String value) {
        this.nombretipocpu = value;
    }

}
