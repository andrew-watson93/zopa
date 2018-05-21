/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.zopa.lending;

import java.util.List;

/**
 *
 * @author andre
 */
public class LendingRequest {

    private Float amount;
    private List<Lender> lenders;

    public LendingRequest() {
    }

    public LendingRequest(Float amount, List<Lender> lenders) {
        this.amount = amount;
        this.lenders = lenders;
    }

    /**
     * @return the amount
     */
    public Float getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(Float amount) {
        this.amount = amount;
    }

    /**
     * @return the lenders
     */
    public List<Lender> getLenders() {
        return lenders;
    }

    /**
     * @param lenders the lenders to set
     */
    public void setLenders(List<Lender> lenders) {
        this.lenders = lenders;
    }

}
