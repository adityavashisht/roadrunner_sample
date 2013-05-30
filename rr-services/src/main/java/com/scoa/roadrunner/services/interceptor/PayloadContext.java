package com.scoa.roadrunner.services.interceptor;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;


public class PayloadContext implements Serializable {

    private static final ConcurrentHashMap<String, Object> logTraceMap = new ConcurrentHashMap<String, Object>();
    /**
     * @return
     */
    public ConcurrentHashMap<String, Object> getLogTraceMap() {
        return logTraceMap;
    }


}
