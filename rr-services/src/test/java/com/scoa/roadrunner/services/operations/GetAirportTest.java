package com.scoa.roadrunner.services.operations;

import com.scoa.roadrunner.connector.jaxb.GetAirport;
import com.scoa.roadrunner.connector.jaxb.GetAirportResponse;
import com.scoa.roadrunner.services.extractor.GetAirportExtractor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.WebServiceTemplate;

import org.springframework.ws.soap.SoapHeader;
import org.springframework.ws.soap.SoapMessage;
import org.springframework.xml.transform.StringSource;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/com/scoa/roadrunner/services/connector-api.xml")
public class GetAirportTest {

    @Autowired
    private WebServiceTemplate webServiceTemplate;

    @Test
    public void testGetAirport() {
        GetAirportResponse response = (GetAirportResponse) webServiceTemplate.marshalSendAndReceive(getAirport(), new WebServiceMessageCallback() {
            public void doWithMessage(WebServiceMessage message)
                    throws IOException, TransformerException {
                SoapMessage soapMessage = (SoapMessage) message;
                SoapHeader soapHeader = ((SoapMessage) message).getSoapHeader();
                soapMessage.setSoapAction("http://tempuri.org/GetAirport");
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
        });
        assertNotNull(response);
    }

    public GetAirport getAirport() {
        GetAirport g = new GetAirport();
        g.setPreFix("P");
        return g;
    }


    @Test
    public void testGetAirportToResult() {

        StringWriter finalResponseWriter = new StringWriter();
        // Creating the Source and Result object, that will contain the corressponding REUQEST & RESPONSE.
        StreamSource webServiceInput = new StreamSource(new StringReader(marshalRequestAsString().toString()));
        StreamResult webServiceOutput = new StreamResult(finalResponseWriter);
        // Invoking the Web Service

        webServiceTemplate.sendSourceAndReceiveToResult(webServiceInput, new WebServiceMessageCallback() {
            @Override
            public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException {

                SoapMessage soapMessage = (SoapMessage) message;
                SoapHeader soapHeader = ((SoapMessage) message).getSoapHeader();
                soapMessage.setSoapAction("http://tempuri.org/GetAirport");
                soapMessage.getEnvelope().addNamespaceDeclaration("ns2", "http://tempuri.org/");
                StringBuilder sbHeader = new StringBuilder();
                sbHeader.append("<ns2:AuthSoapHd  xmlns:ns2=\"http://tempuri.org/\">")
                        .append("<ns2:UserName>Phoenix</ns2:UserName>")
                        .append("<ns2:Password>Phoenix_1#</ns2:Password>")
                        .append("</ns2:AuthSoapHd>");
                StringSource stringSource = new StringSource(sbHeader.toString());
                Transformer transformer = TransformerFactory.newInstance().newTransformer();
                transformer.transform(stringSource, soapHeader.getResult());
                System.out.println(stringSource);
            }
        }, webServiceOutput);

        System.out.println(webServiceOutput);


    }


    @Test
    public void testGetAirportToResultWithExtractor() {

        StringWriter finalResponseWriter = new StringWriter();
        // Creating the Source and Result object, that will contain the corressponding REUQEST & RESPONSE.
        StreamSource webServiceInput = new StreamSource(new StringReader(marshalRequestAsString().toString()));
        StreamResult webServiceOutput = new StreamResult(finalResponseWriter);

        GetAirportExtractor airportExtractor = new GetAirportExtractor();
        // Invoking the Web Service

        Object value = webServiceTemplate.sendSourceAndReceive(webServiceInput, new WebServiceMessageCallback() {
            @Override
            public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException {

                SoapMessage soapMessage = (SoapMessage) message;
                SoapHeader soapHeader = ((SoapMessage) message).getSoapHeader();
                soapMessage.setSoapAction("http://tempuri.org/GetAirport");
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
        }, airportExtractor);

        System.out.println(value);


    }


    public StringWriter marshalRequestAsString() {
        StringWriter stringWriter = new StringWriter();
        try {
            JAXBContext jc = JAXBContext.newInstance("com.scoa.roadrunner.connector.jaxb");
            Marshaller m = jc.createMarshaller();
            //m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //m.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);

            GetAirport airport = this.getAirport();
            m.marshal(airport, stringWriter);

        } catch (Exception ex) {

        }
        return stringWriter;
    }


}
