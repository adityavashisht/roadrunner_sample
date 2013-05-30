package com.scoa.roadrunner.services.interceptor;


public class ThreadLocalPayload {

    private static final ThreadLocal<PayloadContext> payloadContext = new ThreadLocal<PayloadContext>();

    public static void bind(PayloadContext payload) {
        payloadContext.set(payload);
    }

    public static void unBind() {
        if (getPayloadContext() != null && getPayloadContext().getLogTraceMap() != null) {
            getPayloadContext().getLogTraceMap().clear();
        }
        payloadContext.set(null);
    }

    public static PayloadContext getPayloadContext() {
        return payloadContext.get();
    }
}
