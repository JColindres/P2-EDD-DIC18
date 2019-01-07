
package ServiciosWeb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for QuitarLista complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="QuitarLista">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="user" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="prod" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QuitarLista", propOrder = {
    "user",
    "prod"
})
public class QuitarLista {

    protected int user;
    protected int prod;

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
     * Gets the value of the prod property.
     * 
     */
    public int getProd() {
        return prod;
    }

    /**
     * Sets the value of the prod property.
     * 
     */
    public void setProd(int value) {
        this.prod = value;
    }

}
