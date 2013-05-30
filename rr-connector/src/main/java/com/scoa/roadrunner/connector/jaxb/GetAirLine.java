
package com.scoa.roadrunner.connector.jaxb;

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
 *         &lt;element name="PreFix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "preFix"
})
@XmlRootElement(name = "GetAirLine", namespace = "http://tempuri.org/")
public class GetAirLine {

    @XmlElement(name = "PreFix", namespace = "http://tempuri.org/")
    protected String preFix;

    /**
     * Gets the value of the preFix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreFix() {
        return preFix;
    }

    /**
     * Sets the value of the preFix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreFix(String value) {
        this.preFix = value;
    }

}
