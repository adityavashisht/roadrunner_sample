
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
 *         &lt;element name="ReservationNo" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "reservationNo"
})
@XmlRootElement(name = "EmailResDetails")
public class EmailResDetails {

    @XmlElement(name = "ReservationNo")
    protected int reservationNo;

    /**
     * Gets the value of the reservationNo property.
     * 
     */
    public int getReservationNo() {
        return reservationNo;
    }

    /**
     * Sets the value of the reservationNo property.
     * 
     */
    public void setReservationNo(int value) {
        this.reservationNo = value;
    }

}
