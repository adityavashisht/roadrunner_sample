package com.scoa.roadrunner.services.unmarshal;

import com.scoa.roadrunner.connector.jaxb.GetAirportResponse;

import javax.xml.bind.JAXBContext;

import javax.xml.bind.Unmarshaller;
import java.io.File;


public class UnMarshal {

    public static void main(String[] args) {
        JAXBContext jc = null;
        try {
            jc = JAXBContext.newInstance("com.scoa.roadrunner.connector.jaxb");
            Unmarshaller um = jc.createUnmarshaller();
            GetAirportResponse response = (GetAirportResponse)
                    um.unmarshal(new java.io.FileInputStream(new File("D:\\GIT_PROJECTS\\roadrunner_master\\rr-services\\src\\main\\test\\java\\com\\scoa\\roadrunner\\services\\unmarshal\\response.xml")));
            System.out.println(response.getGetAirportResult().getContent());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
