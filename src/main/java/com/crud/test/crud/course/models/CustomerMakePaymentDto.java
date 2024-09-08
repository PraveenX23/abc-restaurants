package com.crud.test.crud.course.models;

import jakarta.validation.constraints.NotEmpty;

public class CustomerMakePaymentDto {
    
    @NotEmpty(message= "The name is required")
    private String name;

    @NotEmpty(message= "The card number is required")
    private String cardnumber;

    @NotEmpty(message= "The expired date and month is required")
    private String expdate;

    @NotEmpty(message= "The cvcd is required")
    private String cvc;

    public @NotEmpty(message = "The name is required") String getName() {
        return name;
    }

    public void setName(@NotEmpty(message = "The name is required") String name) {
        this.name = name;
    }

    public @NotEmpty(message = "The card number is required") String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(@NotEmpty(message = "The card number is required") String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public @NotEmpty(message = "The expired date and month is required") String getExpdate() {
        return expdate;
    }

    public void setExpdate(@NotEmpty(message = "The expired date and month is required") String expdate) {
        this.expdate = expdate;
    }

    public @NotEmpty(message = "The cvcd is required") String getCvc() {
        return cvc;
    }

    public void setCvc(@NotEmpty(message = "The cvcd is required") String cvc) {
        this.cvc = cvc;
    }
}
