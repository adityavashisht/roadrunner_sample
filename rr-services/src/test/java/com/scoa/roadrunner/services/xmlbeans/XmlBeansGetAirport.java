package com.scoa.roadrunner.services.xmlbeans;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ws.client.core.WebServiceTemplate;



/**
 * Created with IntelliJ IDEA.
 * User: AdityaVashisht
 * Date: 3/29/13
 * Time: 2:37 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/com/scoa/roadrunner/services/connector-api.xml")
public class XmlBeansGetAirport {

    @Autowired
    private WebServiceTemplate webServiceTemplate;


    @Test
    public void testGetAirport() {



    }


   /* public GetAirportDocument getAirportDocument() {
        GetAirportDocument airportDocument = GetAirportDocument.Factory.newInstance();
        AuthSoapHd soapHd = AuthSoapHd.Factory.newInstance();
        return airportDocument;
    }*/
}
