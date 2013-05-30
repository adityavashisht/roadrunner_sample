package com.scoa.roadrunner.services.operations;


import com.scoa.roadrunner.connector.jaxb.GetFareForReservation;
import com.scoa.roadrunner.connector.jaxb.GetFareForReservationResponse;
import org.junit.Ignore;
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
import javax.xml.namespace.QName;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/com/scoa/roadrunner/services/connector-api.xml")
public class GetFareForReservationTest {

    @Autowired
    private WebServiceTemplate webServiceTemplate;

    @Ignore
    public void testGetFareForReservation() {
        GetFareForReservationResponse response = (GetFareForReservationResponse) webServiceTemplate.marshalSendAndReceive(getFareForReservation(), new WebServiceMessageCallback() {
            public void doWithMessage(WebServiceMessage message)
                    throws IOException, TransformerException {
                SoapHeader soapHeader = ((SoapMessage) message).getSoapHeader();
                QName headerElementName = new QName("http://tempuri.org", "AuthSoapHd");
                soapHeader.addHeaderElement(headerElementName);
                QName username = new QName("http://tempuri.org", "UserName");
                soapHeader.addHeaderElement(username).setText("Phoenix");
                QName password = new QName("http://tempuri.org", "Password");
                soapHeader.addHeaderElement(password).setText("Phoenix_1#");
            }

        });
        assertNotNull(response);
    }

    @Test
    public void testMethod() {

    }

    public GetFareForReservation getFareForReservation() {
        GetFareForReservation g = new GetFareForReservation();
        g.setDepAirport("PHX");
        g.setDepZip("85021");
        g.setDepPessanger("2");
        g.setDepDate("03/28/2013");
        return g;
    }
}
