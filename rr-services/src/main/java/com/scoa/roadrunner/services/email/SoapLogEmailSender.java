package com.scoa.roadrunner.services.email;


import java.util.Map;

public interface SoapLogEmailSender {
    public void send(Map<String, Object> hTemplateVariables);
}
