package com.scoa.roadrunner.services.extractor;

import com.scoa.roadrunner.common.dto.ReservationFare;
import org.springframework.ws.client.core.SourceExtractor;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Extracts data from the GetFareForReservation, SOAP response
 * Looks for Price element and pr
 * @author Aditya Vashisht
 */
public class GetFareForReservationExtractor implements SourceExtractor {

    /**
     *
     * @param source
     * @return
     * @throws IOException
     * @throws TransformerException
     */
    @Override
    public Object extractData(Source source) throws IOException, TransformerException {
        DOMSource domSource = (DOMSource) source;
        Node node = domSource.getNode();
        NodeList nodeList = node.getFirstChild().getFirstChild().getChildNodes();
        List<ReservationFare> reservationFares = new ArrayList<>();
        if (nodeList.getLength() != 0) {
            int length = nodeList.getLength();
            for (int index = 0; index < length; index++) {
                Node detailNode = nodeList.item(index);
                ReservationFare reservationFare = null;
                boolean errorOnDecimalAmount = false;
                if (detailNode != null && "Detail".equals(detailNode.getNodeName())) {
                    reservationFare = new ReservationFare();
                    NodeList detailNodeChildren = detailNode.getChildNodes();
                    int detailNodeLength = detailNodeChildren.getLength();
                    for (int count = 0; count < detailNodeLength; count++) {
                        Node nodeChild = detailNodeChildren.item(count);
                        if ("Price".equals(nodeChild.getNodeName())) {
                            try {
                                BigDecimal amount = new BigDecimal(nodeChild.getFirstChild().getNodeValue());
                                reservationFare.setAmount(amount);
                            } catch (Exception ex) {
                                errorOnDecimalAmount = true;
                            }
                        } else if ("ServiceId".equals(nodeChild.getNodeName())) {
                            reservationFare.setServiceId(nodeChild.getFirstChild().getNodeValue());

                        } else if ("Vehicle".equals(nodeChild.getNodeName())) {
                            reservationFare.setVehicleType(nodeChild.getFirstChild().getNodeValue());

                        } else if ("Gratuity".equals(nodeChild.getNodeName())) {
                            try {
                                BigDecimal gratuity = new BigDecimal(nodeChild.getFirstChild().getNodeValue());
                                reservationFare.setGratuityAmount(gratuity);
                            } catch (Exception ex) {
                                reservationFare.setGratuityAmount(new BigDecimal("0.00"));
                            }
                        }
                    }
                    // Only add if a fare is present in the list
                    if (!errorOnDecimalAmount) {
                        reservationFares.add(reservationFare);
                    }
                }
            }
        }
        ReservationFare fare = new ReservationFare();
        if(!reservationFares.isEmpty()) {
            fare = reservationFares.get(0);
        }
        return fare;
    }
}
