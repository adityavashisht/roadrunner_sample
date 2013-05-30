
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
 *         &lt;element name="UpdateMode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ResId" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "updateMode",
    "resId"
})
@XmlRootElement(name = "CancelReservation")
public class CancelReservation {

    @XmlElement(name = "UpdateMode")
    protected int updateMode;
    @XmlElement(name = "ResId")
    protected int resId;

    /**
     * Gets the value of the updateMode property.
     * 
     */
    public int getUpdateMode() {
        return updateMode;
    }

    /**
     * Sets the value of the updateMode property.
     * 
     */
    public void setUpdateMode(int value) {
        this.updateMode = value;
    }

    /**
     * Gets the value of the resId property.
     * 
     */
    public int getResId() {
        return resId;
    }

    /**
     * Sets the value of the resId property.
     * 
     */
    public void setResId(int value) {
        this.resId = value;
    }

}
