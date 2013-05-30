package com.scoa.roadrunner.services.gateway;

import com.scoa.roadrunner.common.dto.KeyValueDropDown;
import com.scoa.roadrunner.common.dto.ReservationFare;
import com.scoa.roadrunner.common.payload.ReservationFareRequest;
import com.scoa.roadrunner.common.payload.SaveReservationRequest;
import com.scoa.roadrunner.common.payload.SaveReservationResponse;
import com.scoa.roadrunner.connector.jaxb.GetAirLine;
import com.scoa.roadrunner.connector.jaxb.GetAirport;
import com.scoa.roadrunner.connector.jaxb.GetFareForReservation;
import com.scoa.roadrunner.connector.jaxb.SaveReservation;
import com.scoa.roadrunner.domain.reservation.Reservation;
import com.scoa.roadrunner.services.binder.SaveReservationRequestBinder;
import com.scoa.roadrunner.services.extractor.GetAirlineExtractor;
import com.scoa.roadrunner.services.extractor.GetAirportExtractor;
import com.scoa.roadrunner.services.extractor.GetFareForReservationExtractor;
import com.scoa.roadrunner.services.extractor.SaveReservationExtractor;
import com.scoa.roadrunner.services.interceptor.PayloadContext;
import com.scoa.roadrunner.services.interceptor.ThreadLocalPayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.WebServiceTemplate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 *
 *
 *
 *
 *
 */
@Service("rrGateway")
@SuppressWarnings("unchecked")
public class RRGatewayImpl implements RRGateway {

    private static final Logger logger = LoggerFactory.getLogger(RRGatewayImpl.class);

    @Autowired
    WebServiceTemplate webServiceTemplate;

    @Autowired
    SoapHeaderBuilder soapHeaderBuilder;


    /**
     * @param prefix
     * @return
     */
    @Override
    public List<KeyValueDropDown> getAirportByPrefix(String prefix) {
        GetAirport g = new GetAirport();
        g.setPreFix(prefix);
        List<KeyValueDropDown> dropDowns = new ArrayList<>();
        String marshalledType = this.marshalRequestAsString(g).toString();
        if (StringUtils.hasText(marshalledType)) {
            StreamSource webServiceInput = new StreamSource(new StringReader(marshalledType));
            GetAirportExtractor airportExtractor = new GetAirportExtractor();
            // Invoking the Web Service
            try {
                dropDowns = (List<KeyValueDropDown>) webServiceTemplate.sendSourceAndReceive(webServiceInput, new WebServiceMessageCallback() {
                    @Override
                    public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException {
                        // TO DO Add this logic as interceptor call
                        soapHeaderBuilder.addSoapHeader(message, "GetAirport");
                        PayloadContext context = new PayloadContext();
                        context.getLogTraceMap().put("SUBJECT", "RR-API " + "GetAirport");
                        ThreadLocalPayload.bind(context);
                    }
                }, airportExtractor);
            } finally {
                ThreadLocalPayload.unBind();
            }
        }
        return dropDowns;
    }


    /**
     * @param prefix
     * @return
     */
    @Override
    public List<KeyValueDropDown> getAirlinesByPrefix(String prefix) {
        GetAirLine g = new GetAirLine();
        g.setPreFix(prefix);
        List<KeyValueDropDown> dropDowns = new ArrayList<>();
        String marshalledType = this.marshalRequestAsString(g).toString();
        if (StringUtils.hasText(marshalledType)) {
            StreamSource webServiceInput = new StreamSource(new StringReader(marshalledType));
            GetAirlineExtractor airlineExtractor = new GetAirlineExtractor();
            // Invoking the Web Service
            try {
                dropDowns = (List<KeyValueDropDown>) webServiceTemplate.sendSourceAndReceive(webServiceInput, new WebServiceMessageCallback() {
                    @Override
                    public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException {
                        // TO DO Add this logic as interceptor call
                        soapHeaderBuilder.addSoapHeader(message, "GetAirLine");
                        PayloadContext context = new PayloadContext();
                        context.getLogTraceMap().put("SUBJECT", "RR-API " + "GetAirline");
                        ThreadLocalPayload.bind(context);
                    }
                }, airlineExtractor);
            } finally {
                ThreadLocalPayload.unBind();
            }
        }
        return dropDowns;
    }

    /**
     * @param fareRequest
     * @return
     */
    @Override
    public ReservationFare getReservationFareForRoute(ReservationFareRequest fareRequest) {
        GetFareForReservation g = new GetFareForReservation();
        g.setDiscAmt("");
        g.setQueryString("");
        g.setDiscCode("");

        if (fareRequest.isArrival()) {
            g.setArvAirport(fareRequest.getAirportCode());
            g.setArvPessanger(fareRequest.getPassengerCount());
            g.setArvDate(fareRequest.getDateOfTravel());
            g.setArvZip(fareRequest.getZipCode());

            g.setDepDate("");
            g.setDepAirport("");
            g.setDepDate("");
            g.setDepPessanger("");
        } else {
            g.setDepAirport(fareRequest.getAirportCode());
            g.setDepPessanger(fareRequest.getPassengerCount());
            g.setDepDate(fareRequest.getDateOfTravel());
            g.setDepZip(fareRequest.getZipCode());

            g.setArvDate("");
            g.setArvAirport("");
            g.setArvDate("");
            g.setArvPessanger("");
        }

        String marshalledType = this.marshalRequestAsString(g).toString();
        ReservationFare reservationFare = null;
        if (StringUtils.hasText(marshalledType)) {
            StreamSource webServiceInput = new StreamSource(new StringReader(marshalledType));
            GetFareForReservationExtractor getFareForReservationExtractor = new GetFareForReservationExtractor();
            // Invoking the Web Service
            try {
                reservationFare = (ReservationFare) webServiceTemplate.sendSourceAndReceive(webServiceInput, new WebServiceMessageCallback() {
                    @Override
                    public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException {
                        // TO DO Add this logic as interceptor call
                        soapHeaderBuilder.addSoapHeader(message, "GetFareForReservation");
                        PayloadContext context = new PayloadContext();
                        context.getLogTraceMap().put("SUBJECT", "RR-API " + "GetFareForReservation");
                        ThreadLocalPayload.bind(context);
                    }
                }, getFareForReservationExtractor);
            } finally {
                ThreadLocalPayload.unBind();
            }
        }
        return reservationFare;
    }

    /**
     * Saves and creates a new reservation
     *
     * @param reservationRequest
     * @return
     */
    @Override
    public SaveReservationResponse createNewReservation(SaveReservationRequest reservationRequest) {
        SaveReservationResponse saveReservationResponse = null;
        SaveReservation g = SaveReservationRequestBinder.prepareRequest(reservationRequest);
        String marshalledType = this.marshalRequestAsString(g).toString();
        if (StringUtils.hasText(marshalledType)) {
            StreamSource webServiceInput = new StreamSource(new StringReader(marshalledType));
            SaveReservationExtractor saveReservationExtractor = new SaveReservationExtractor();
            // Invoking the Web Service
            try {
                saveReservationResponse = (SaveReservationResponse) webServiceTemplate.sendSourceAndReceive(webServiceInput, new WebServiceMessageCallback() {
                    @Override
                    public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException {
                        // TO DO Add this logic as interceptor call
                        soapHeaderBuilder.addSoapHeader(message, "SaveReservation");
                        PayloadContext context = new PayloadContext();
                        context.getLogTraceMap().put("SUBJECT", "RR-API " + "SaveReservation");
                        ThreadLocalPayload.bind(context);
                    }
                }, saveReservationExtractor);
            } finally {
                ThreadLocalPayload.unBind();
            }
        }
        return saveReservationResponse;
    }

    /**
     * @param object
     * @return
     */
    public StringWriter marshalRequestAsString(Object object) {
        StringWriter stringWriter = new StringWriter();
        try {
            JAXBContext jc = JAXBContext.newInstance("com.scoa.roadrunner.connector.jaxb");
            Marshaller m = jc.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
            m.marshal(object, stringWriter);
        } catch (Exception ex) {
            logger.error("Error marshalling type for" + object.toString());

        }
        return stringWriter;
    }
}
