package com.scoa.roadrunner.web.extensions;

import org.springframework.webflow.definition.StateDefinition;
import org.springframework.webflow.execution.FlowExecutionListenerAdapter;
import org.springframework.webflow.execution.RequestContext;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: AdityaVashisht
 * Date: 5/6/13
 * Time: 4:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class AppendStateListener extends FlowExecutionListenerAdapter {

    public void stateEntered(RequestContext context, StateDefinition previousState, StateDefinition newState) {
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getNativeRequest();
        request.getSession().setAttribute("page", newState.getId());
    }

}
