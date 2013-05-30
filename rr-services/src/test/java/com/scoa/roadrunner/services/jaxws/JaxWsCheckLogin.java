package com.scoa.roadrunner.services.jaxws;

import com.scoa.roadrunner.connector.api.RR09;
import com.scoa.roadrunner.services.jaxws.handler.ClientHandlerResolver;

/**
 * Created with IntelliJ IDEA.
 * User: Aditya
 * Date: 3/28/13
 * Time: 10:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class JaxWsCheckLogin {

    public static void main(String [] args) {
        RR09 rr09 = new RR09();
        rr09.setHandlerResolver(new ClientHandlerResolver());
        Object object =  rr09.getRR09Soap().checkLogin("Phoenix", "Phoenix_1#");

        System.out.println(object);
    }

}
