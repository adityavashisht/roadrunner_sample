package com.scoa.roadrunner.services.jaxws;


import com.scoa.roadrunner.connector.api.RR09;
import com.scoa.roadrunner.services.jaxws.handler.ClientHandlerResolver;

public class JaxWsGetAirport {

    public static void main(String [] args) {
        RR09 rr09 = new RR09();
        rr09.setHandlerResolver(new ClientHandlerResolver());
        Object object =  rr09.getRR09Soap().getAirport("PHX") ;

        System.out.println(object);
    }


}
