package com.scoa.roadrunner.services.interceptor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.WebServiceClientException;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.endpoint.interceptor.PayloadLoggingInterceptor;
import org.springframework.ws.soap.SoapHeader;
import org.springframework.ws.soap.SoapMessage;
import org.springframework.xml.transform.StringSource;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: AdityaVashisht
 * Date: 4/10/13
 * Time: 10:21 AM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class SoapHeaderAuthInterceptor implements ClientInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(SoapHeaderAuthInterceptor.class);

    @Override
    public boolean handleRequest(MessageContext messageContext) throws WebServiceClientException {
        WebServiceMessage message = messageContext.getRequest();
        SoapMessage soapMessage = (SoapMessage) message;
        SoapHeader soapHeader = ((SoapMessage) message).getSoapHeader();
        soapMessage.getEnvelope().addNamespaceDeclaration("ns2", "http://tempuri.org/");
        StringBuilder sbHeader = new StringBuilder();
        sbHeader.append("<ns2:AuthSoapHd  xmlns:ns2=\"http://tempuri.org/\">")
                .append("<ns2:UserName>Phoenix</ns2:UserName>")
                .append("<ns2:Password>Phoenix_1#</ns2:Password>")
                .append("</ns2:AuthSoapHd>");
        StringSource stringSource = new StringSource(sbHeader.toString());
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(stringSource, soapHeader.getResult());
        } catch (Exception ex) {
            logger.error("Could not transform request, authorization failure");
        }
        return true;
    }

    @Override
    public boolean handleResponse(MessageContext messageContext) throws WebServiceClientException {
        return false;
    }

    @Override
    public boolean handleFault(MessageContext messageContext) throws WebServiceClientException {
        return false;
    }
}
