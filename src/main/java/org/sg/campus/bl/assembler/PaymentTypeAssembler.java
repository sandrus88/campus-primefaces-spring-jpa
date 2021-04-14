package org.sg.campus.bl.assembler;

import org.sg.campus.bl.domain.PaymentType;

public class PaymentTypeAssembler {

    public static PaymentType getEnum(String paymentAsString){
    	if(paymentAsString == null) {
    		return null;
    	}
        return PaymentType.valueOf(paymentAsString);
    }
    
    public static String getString(PaymentType paymentAsEnum){
    	if(paymentAsEnum == null) {
    		return null;
    	}
        return paymentAsEnum.toString();
    }
}
