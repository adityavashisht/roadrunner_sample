package com.scoa.roadrunner.services.gateway;


import org.springframework.stereotype.Component;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.soap.SoapHeader;
import org.springframework.ws.soap.SoapMessage;
import org.springframework.xml.transform.StringSource;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;

@Component
public class SoapHeaderBuilder {

    /**
     * Add soap header to each outgoing request
     * @param message
     * @param action
     * @throws TransformerConfigurationException
     * @throws TransformerException
     */
    public void addSoapHeader(WebServiceMessage message, String action) throws TransformerException {
        SoapMessage soapMessage = (SoapMessage) message;
        SoapHeader soapHeader = ((SoapMessage) message).getSoapHeader();
        String soapAction = "http://tempuri.org/" + action;
        soapMessage.setSoapAction(soapAction);
        soapMessage.getEnvelope().addNamespaceDeclaration("ns2", "http://tempuri.org/");
        StringBuilder sbHeader = new StringBuilder();
        sbHeader.append("<ns2:AuthSoapHd  xmlns:ns2=\"http://tempuri.org/\">")
                .append("<ns2:UserName>Phoenix</ns2:UserName>")
                .append("<ns2:Password>Phoenix_1#</ns2:Password>")
                .append("</ns2:AuthSoapHd>");
        StringSource stringSource = new StringSource(sbHeader.toString());
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(stringSource, soapHeader.getResult());
    }

}
