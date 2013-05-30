package com.scoa.roadrunner.web.extensions;

import org.springframework.web.util.WebUtils;
import org.springframework.webflow.context.servlet.DefaultFlowUrlHandler;
import org.springframework.webflow.context.servlet.FlowUrlHandler;
import org.springframework.webflow.core.collection.AttributeMap;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: AdityaVashisht
 * Date: 5/6/13
 * Time: 4:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class CustomFlowUrlHandler extends DefaultFlowUrlHandler {

    public String createFlowExecutionUrl(String flowId, String flowExecutionKey, HttpServletRequest request) {
        String state = (String) request.getSession().getAttribute("page");
        StringBuffer url = new StringBuffer();
        url.append(request.getRequestURI());
        url.append('?');
        appendQueryParameter(url, FLOW_EXECUTION_KEY_PARAMETER, flowExecutionKey,  WebUtils.DEFAULT_CHARACTER_ENCODING);
        return url.toString() + "&page="+ state;
    }

    private void appendQueryParameter(StringBuffer url, Object key, Object value, String encodingScheme) {
        String encodedKey = encode(key, encodingScheme);
        String encodedValue = encode(value, encodingScheme);
        url.append(encodedKey).append('=').append(encodedValue);
    }

    private String encode(Object value, String encodingScheme) {
        return value != null ? urlEncode(value.toString(), encodingScheme) : "";
    }

    private String urlEncode(String value, String encodingScheme) {
        try {
            return URLEncoder.encode(value, encodingScheme);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException("Cannot url encode " + value);
        }
    }

    private static final String FLOW_EXECUTION_KEY_PARAMETER = "execution";



}
