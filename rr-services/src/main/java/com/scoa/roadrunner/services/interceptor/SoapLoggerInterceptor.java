package com.scoa.roadrunner.services.interceptor;

import com.scoa.roadrunner.services.email.SoapLogEmailSender;
import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.WebServiceClientException;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.endpoint.AbstractLoggingInterceptor;
import org.springframework.ws.soap.SoapMessage;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.util.concurrent.locks.ReentrantLock;

@Component
public class SoapLoggerInterceptor extends AbstractLoggingInterceptor implements ClientInterceptor {

    private final ReentrantLock LOCK = new ReentrantLock();


    @Autowired
    private SoapLogEmailSender soapLogEmailSender;

    /**
     * @param messageContext
     * @return
     * @throws WebServiceClientException
     */
    @Override
    public boolean handleRequest(MessageContext messageContext) throws WebServiceClientException {
        try {
            PayloadContext context = ThreadLocalPayload.getPayloadContext();
            if (context != null) {
                LOCK.lock();

                Source xmlSource = getSource(messageContext.getRequest());
                String requestPayload = logMessageSourceAsString(xmlSource);
                requestPayload = StringEscapeUtils.escapeXml(requestPayload);
                context.getLogTraceMap().put("REQUEST", requestPayload);
                // Retain traditional logging mechanism for this request
                logMessageSource("SOAP REQUEST: ", xmlSource);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("Not supposed to occur" + ex.getMessage());
        } finally {
            if (LOCK.isLocked()) {
                LOCK.unlock();
            }
        }
        return true;
    }

    /**
     * @param messageContext
     * @return
     * @throws WebServiceClientException
     */
    @Override
    public boolean handleResponse(MessageContext messageContext) throws WebServiceClientException {
        try {
            PayloadContext context = ThreadLocalPayload.getPayloadContext();
            if (context != null) {
                LOCK.lock();

            Source xmlSource = getSource(messageContext.getResponse());
            String response = logMessageSourceAsString(xmlSource);
            response = StringEscapeUtils.escapeXml(response);
            context.getLogTraceMap().put("RESPONSE", response);
            logMessageSource("SOAP RESPONSE: ", xmlSource);
            soapLogEmailSender.send(context.getLogTraceMap());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("Not supposed to occur" + ex.getMessage());
        } finally {
            if (LOCK.isLocked()) {
                LOCK.unlock();
            }
        }
        return true;
    }

    @Override
    public boolean handleFault(MessageContext messageContext) throws WebServiceClientException {
        return true;
    }

    @Override
    protected Source getSource(WebServiceMessage message) {
        if (message instanceof SoapMessage) {
            SoapMessage soapMessage = (SoapMessage) message;
            return soapMessage.getEnvelope().getSource();
        } else {
            return message.getPayloadSource();
        }
    }

    private Transformer createIndentingTransformer() throws TransformerConfigurationException {
        Transformer transformer = createTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        return transformer;
    }

    /**
     * Logs the given {@link Source source} to the {@link #logger}, using the message as a prefix.
     * <p/>
     * By default, this message creates a string representation of the given source, and delegates to {@link
     * #logMessage(String)}.
     *
     * @param source the source to be logged
     * @throws javax.xml.transform.TransformerException
     *          in case of errors
     */
    public String logMessageSourceAsString(Source source) throws TransformerException {
        String message = null;
        if (source != null) {
            Transformer transformer = createIndentingTransformer();
            StringWriter writer = new StringWriter();
            transformer.transform(source, new StreamResult(writer));
            message = writer.toString();

        }
        return message;
    }


}
