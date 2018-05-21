/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.zopa.lender.main;

import com.mycompany.zopa.lending.LendingRequest;
import com.mycompany.zopa.service.LendingRequestBuilder;
import com.mycompany.zopa.service.LendingRequestProcessor;
import java.io.FileNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author andre
 */
public class Launcher {

    @Autowired
    private LendingRequestBuilder requestBuilder;

    @Autowired
    private LendingRequestProcessor requestProcessor;

    public void run(String[] args) throws FileNotFoundException {
        LendingRequest request = requestBuilder.build(args);
        requestProcessor.process(request);
    }

}
