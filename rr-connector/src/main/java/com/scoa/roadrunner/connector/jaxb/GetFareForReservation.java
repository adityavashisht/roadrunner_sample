
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
 *         &lt;element name="DepAirport" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DepZip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DepPessanger" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DepDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ArvAirport" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ArvZip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ArvPessanger" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ArvDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="QueryString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DiscCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DiscAmt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "depAirport",
    "depZip",
    "depPessanger",
    "depDate",
    "arvAirport",
    "arvZip",
    "arvPessanger",
    "arvDate",
    "queryString",
    "discCode",
    "discAmt"
})
@XmlRootElement(name = "GetFareForReservation", namespace = "http://tempuri.org/")
public class GetFareForReservation {

    @XmlElement(name = "DepAirport", namespace = "http://tempuri.org/")
    protected String depAirport;
    @XmlElement(name = "DepZip", namespace = "http://tempuri.org/")
    protected String depZip;
    @XmlElement(name = "DepPessanger", namespace = "http://tempuri.org/")
    protected String depPessanger;
    @XmlElement(name = "DepDate", namespace = "http://tempuri.org/")
    protected String depDate;
    @XmlElement(name = "ArvAirport", namespace = "http://tempuri.org/")
    protected String arvAirport;
    @XmlElement(name = "ArvZip", namespace = "http://tempuri.org/")
    protected String arvZip;
    @XmlElement(name = "ArvPessanger", namespace = "http://tempuri.org/")
    protected String arvPessanger;
    @XmlElement(name = "ArvDate", namespace = "http://tempuri.org/")
    protected String arvDate;
    @XmlElement(name = "QueryString", namespace = "http://tempuri.org/")
    protected String queryString;
    @XmlElement(name = "DiscCode", namespace = "http://tempuri.org/")
    protected String discCode;
    @XmlElement(name = "DiscAmt", namespace = "http://tempuri.org/")
    protected String discAmt;

    /**
     * Gets the value of the depAirport property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepAirport() {
        return depAirport;
    }

    /**
     * Sets the value of the depAirport property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepAirport(String value) {
        this.depAirport = value;
    }

    /**
     * Gets the value of the depZip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepZip() {
        return depZip;
    }

    /**
     * Sets the value of the depZip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepZip(String value) {
        this.depZip = value;
    }

    /**
     * Gets the value of the depPessanger property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepPessanger() {
        return depPessanger;
    }

    /**
     * Sets the value of the depPessanger property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepPessanger(String value) {
        this.depPessanger = value;
    }

    /**
     * Gets the value of the depDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepDate() {
        return depDate;
    }

    /**
     * Sets the value of the depDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepDate(String value) {
        this.depDate = value;
    }

    /**
     * Gets the value of the arvAirport property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArvAirport() {
        return arvAirport;
    }

    /**
     * Sets the value of the arvAirport property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArvAirport(String value) {
        this.arvAirport = value;
    }

    /**
     * Gets the value of the arvZip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArvZip() {
        return arvZip;
    }

    /**
     * Sets the value of the arvZip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArvZip(String value) {
        this.arvZip = value;
    }

    /**
     * Gets the value of the arvPessanger property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArvPessanger() {
        return arvPessanger;
    }

    /**
     * Sets the value of the arvPessanger property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArvPessanger(String value) {
        this.arvPessanger = value;
    }

    /**
     * Gets the value of the arvDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArvDate() {
        return arvDate;
    }

    /**
     * Sets the value of the arvDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArvDate(String value) {
        this.arvDate = value;
    }

    /**
     * Gets the value of the queryString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQueryString() {
        return queryString;
    }

    /**
     * Sets the value of the queryString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQueryString(String value) {
        this.queryString = value;
    }

    /**
     * Gets the value of the discCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiscCode() {
        return discCode;
    }

    /**
     * Sets the value of the discCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiscCode(String value) {
        this.discCode = value;
    }

    /**
     * Gets the value of the discAmt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiscAmt() {
        return discAmt;
    }

    /**
     * Sets the value of the discAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiscAmt(String value) {
        this.discAmt = value;
    }

}
