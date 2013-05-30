package com.scoa.roadrunner.services.extractor;



import com.scoa.roadrunner.common.payload.SaveReservationResponse;
import org.springframework.ws.client.core.SourceExtractor;

import org.w3c.dom.Node;


import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import java.io.IOException;

/**
 *
 *
 *
 */
public class SaveReservationExtractor implements SourceExtractor {
    @Override
    public Object extractData(Source source) throws IOException, TransformerException {
        SaveReservationResponse reservationResponse = new SaveReservationResponse();
        DOMSource domSource = (DOMSource) source;
        Node node = domSource.getNode();
        Node reserveNode =  node.getFirstChild().getFirstChild().getFirstChild();
        if(reserveNode.getNodeName().equals("Reservation")) {
            String id = reserveNode.getFirstChild().getNodeValue();
            reservationResponse.setId(id);
        }
        return reservationResponse;
    }
}
