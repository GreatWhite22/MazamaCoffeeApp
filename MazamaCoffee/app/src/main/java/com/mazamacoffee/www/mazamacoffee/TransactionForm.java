package com.mazamacoffee.www.mazamacoffee;

/**
 * Created by Connor Lewis on 5/30/2016.
 */
public interface TransactionForm {
    public String getCardNumber();
    public String getCVV();
    public Integer getExpMonth();
    public Integer getExpYear();
}
