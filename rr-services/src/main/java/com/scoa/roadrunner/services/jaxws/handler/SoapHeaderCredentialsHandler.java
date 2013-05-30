package com.scoa.roadrunner.services.jaxws.handler;





import javax.xml.namespace.QName;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.Set;

/**
 *
 *
 *
 */
public class SoapHeaderCredentialsHandler implements SOAPHandler<SOAPMessageContext> {
    @Override
    public Set<QName> getHeaders() {
        return null;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        Boolean isOutgoing = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if (isOutgoing) {
            try {
                SOAPMessage soapMessage = context.getMessage();
                SOAPEnvelope envelope = soapMessage.getSOAPPart().getEnvelope();
                SOAPHeader soapHeader  = envelope.getHeader();
                if(soapHeader == null) {
                   soapHeader = envelope.addHeader();
                }


                QName AuthSoapHd = new QName("http://tempuri.org/", "AuthSoapHd");
                SOAPHeaderElement userCredentials = soapHeader.addHeaderElement(AuthSoapHd);

                QName UserName = new QName("http://tempuri.org/", "UserName");
                SOAPHeaderElement username = soapHeader.addHeaderElement(UserName );
                username.addTextNode("Phoenix");
                QName Password = new QName("http://tempuri.org/", "Password");
                SOAPHeaderElement password = soapHeader.addHeaderElement(Password);
                password.addTextNode("Phoenix_1#");
                userCredentials.addChildElement(username);
                userCredentials.addChildElement(password);
                soapMessage.saveChanges();


            } catch (SOAPException se) {

            }

        }

        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        return false;
    }

    @Override
    public void close(MessageContext context) {

    }
}
