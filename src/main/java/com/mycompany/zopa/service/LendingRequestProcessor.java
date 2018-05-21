/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.zopa.service;

import com.mycompany.zopa.lending.LendingRequest;

/**
 *
 * @author andre
 */
public class LendingRequestProcessor {

    public String process(LendingRequest request) {
        Double maxAmountToBorrow = request.getLenders()
                .stream()
                .mapToDouble(l -> l.getAvailable())
                .sum();
        if (maxAmountToBorrow < request.getAmount()) {
            return "Loan not available, insufficent funds";
        }
        return "";

    }

}
