
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
 *         &lt;element name="TransId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="UserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="QGUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VaultKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustId" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "transId",
    "userName",
    "qgUser",
    "vaultKey",
    "custId"
})
@XmlRootElement(name = "ChargeNowFromQGWithCustID", namespace = "http://tempuri.org/")
public class ChargeNowFromQGWithCustID {

    @XmlElement(name = "TransId", namespace = "http://tempuri.org/")
    protected int transId;
    @XmlElement(name = "UserName", namespace = "http://tempuri.org/")
    protected String userName;
    @XmlElement(name = "QGUser", namespace = "http://tempuri.org/")
    protected String qgUser;
    @XmlElement(name = "VaultKey", namespace = "http://tempuri.org/")
    protected String vaultKey;
    @XmlElement(name = "CustId", namespace = "http://tempuri.org/")
    protected int custId;

    /**
     * Gets the value of the transId property.
     * 
     */
    public int getTransId() {
        return transId;
    }

    /**
     * Sets the value of the transId property.
     * 
     */
    public void setTransId(int value) {
        this.transId = value;
    }

    /**
     * Gets the value of the userName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the value of the userName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserName(String value) {
        this.userName = value;
    }

    /**
     * Gets the value of the qgUser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQGUser() {
        return qgUser;
    }

    /**
     * Sets the value of the qgUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQGUser(String value) {
        this.qgUser = value;
    }

    /**
     * Gets the value of the vaultKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVaultKey() {
        return vaultKey;
    }

    /**
     * Sets the value of the vaultKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVaultKey(String value) {
        this.vaultKey = value;
    }

    /**
     * Gets the value of the custId property.
     * 
     */
    public int getCustId() {
        return custId;
    }

    /**
     * Sets the value of the custId property.
     * 
     */
    public void setCustId(int value) {
        this.custId = value;
    }

}
