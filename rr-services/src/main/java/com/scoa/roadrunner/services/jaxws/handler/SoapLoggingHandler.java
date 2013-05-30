package com.scoa.roadrunner.services.jaxws.handler;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.io.IOException;
import java.util.Set;


/**
 *
 *
 *
 */
public class SoapLoggingHandler implements SOAPHandler<SOAPMessageContext> {

    @Override
    public Set<QName> getHeaders() {
        return null;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        log(context);
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        return false;
    }

    @Override
    public void close(MessageContext context) {

    }

    /**
     * @param messageContext
     */
    private void log(SOAPMessageContext messageContext) {

        Boolean isOutgoing = (Boolean) messageContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if (isOutgoing) {
            System.out.println("REQUEST:");
        } else {
            System.out.println("------------");
            System.out.println("RESPONSE:");
        }
        SOAPMessage msg = messageContext.getMessage(); //Line 1
        try {
            msg.writeTo(System.out); //Line 3
        } catch (SOAPException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }

    }
}
