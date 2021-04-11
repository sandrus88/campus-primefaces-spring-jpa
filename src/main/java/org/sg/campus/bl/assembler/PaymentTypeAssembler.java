package org.sg.campus.bl.assembler;

import org.sg.campus.web.domain.PaymentType;

public class PaymentTypeAssembler {

    //da enum a string e viceversa

    public PaymentType getEnum(String paymentAsString){
        return PaymentType.valueOf(paymentAsString);
    }

    // get string
}
