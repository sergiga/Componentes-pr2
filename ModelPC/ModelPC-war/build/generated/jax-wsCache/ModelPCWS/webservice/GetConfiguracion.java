
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para getConfiguracion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="getConfiguracion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idConfiguracion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getConfiguracion", propOrder = {
    "idConfiguracion"
})
public class GetConfiguracion {

    protected int idConfiguracion;

    /**
     * Obtiene el valor de la propiedad idConfiguracion.
     * 
     */
    public int getIdConfiguracion() {
        return idConfiguracion;
    }

    /**
     * Define el valor de la propiedad idConfiguracion.
     * 
     */
    public void setIdConfiguracion(int value) {
        this.idConfiguracion = value;
    }

}
