package com.scoa.roadrunner.web.flow.reservation;

import com.scoa.roadrunner.domain.reservation.PaymentInfo;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Aditya
 * Date: 4/21/13
 * Time: 11:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class RouteStepThree implements Serializable {
    private PaymentInfo paymentInfo = new PaymentInfo();
    private Boolean terms;

    public Boolean getTerms() {
        return terms;
    }

    public void setTerms(Boolean terms) {
        this.terms = terms;
    }

    public PaymentInfo getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }
}
