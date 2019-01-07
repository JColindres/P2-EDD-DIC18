
package ServiciosWeb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ModificarLista complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ModificarLista">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="user" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="prodid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cant" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="prod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ModificarLista", propOrder = {
    "user",
    "prodid",
    "cant",
    "prod"
})
public class ModificarLista {

    protected int user;
    protected int prodid;
    protected int cant;
    protected String prod;

    /**
     * Gets the value of the user property.
     * 
     */
    public int getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     * 
     */
    public void setUser(int value) {
        this.user = value;
    }

    /**
     * Gets the value of the prodid property.
     * 
     */
    public int getProdid() {
        return prodid;
    }

    /**
     * Sets the value of the prodid property.
     * 
     */
    public void setProdid(int value) {
        this.prodid = value;
    }

    /**
     * Gets the value of the cant property.
     * 
     */
    public int getCant() {
        return cant;
    }

    /**
     * Sets the value of the cant property.
     * 
     */
    public void setCant(int value) {
        this.cant = value;
    }

    /**
     * Gets the value of the prod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProd() {
        return prod;
    }

    /**
     * Sets the value of the prod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProd(String value) {
        this.prod = value;
    }

}
