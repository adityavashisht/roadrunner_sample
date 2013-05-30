
package com.scoa.roadrunner.connector.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Customerid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "customerid"
})
@XmlRootElement(name = "GetMyReservation")
public class GetMyReservation {

    @XmlElement(name = "Customerid")
    protected int customerid;

    /**
     * Gets the value of the customerid property.
     * 
     */
    public int getCustomerid() {
        return customerid;
    }

    /**
     * Sets the value of the customerid property.
     * 
     */
    public void setCustomerid(int value) {
        this.customerid = value;
    }

}
