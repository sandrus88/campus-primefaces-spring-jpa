package org.sg.campus.bl.assembler;

import org.sg.campus.web.domain.PaymentType;

public class PaymentTypeAssembler {

    public static PaymentType getEnum(String paymentAsString){
        return PaymentType.valueOf(paymentAsString);
    }
    
    public static String getString(PaymentType paymentAsEnum){
        return paymentAsEnum.toString();
    }
}
