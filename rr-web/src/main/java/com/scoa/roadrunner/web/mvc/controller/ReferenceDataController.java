package com.scoa.roadrunner.web.mvc.controller;

import com.scoa.roadrunner.common.dto.KeyValueDropDown;
import com.scoa.roadrunner.common.dto.TypeAheadData;
import com.scoa.roadrunner.services.gateway.RRGateway;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/reference")
public class ReferenceDataController {

    @Autowired
    private RRGateway rrGateway;

    @ResponseBody
    @RequestMapping("/airportCodes")
    public TypeAheadData getAirportCodes(@RequestParam(value = "query", required = true) String query) {
        List<KeyValueDropDown> airports = rrGateway.getAirportByPrefix(query);
        return new TypeAheadData(airports);
    }

    @ResponseBody
    @RequestMapping("/airlines")
    public TypeAheadData getAirlineCodes(@RequestParam(value = "query", required = true) String query) {
        List<KeyValueDropDown> airports = rrGateway.getAirlinesByPrefix(query);
        return new TypeAheadData(airports);

    }

}
