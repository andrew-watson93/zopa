/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.zopa.lending;

/**
 *
 * @author andre
 */
public class Lender {

    private String lender;
    private Double rate;
    private Double available;

    public Lender(String lender, Double rate, Double available) {
        this.lender = lender;
        this.rate = rate;
        this.available = available;
    }

    /**
     * @return the lender
     */
    public String getLender() {
        return lender;
    }

    /**
     * @param lender the lender to set
     */
    public void setLender(String lender) {
        this.lender = lender;
    }

    /**
     * @return the rate
     */
    public Double getRate() {
        return rate;
    }

    /**
     * @param rate the rate to set
     */
    public void setRate(Double rate) {
        this.rate = rate;
    }

    /**
     * @return the available
     */
    public Double getAvailable() {
        return available;
    }

    /**
     * @param available the available to set
     */
    public void setAvailable(Double available) {
        this.available = available;
    }

}
