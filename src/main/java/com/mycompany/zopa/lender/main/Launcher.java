/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.zopa.lender.main;

import org.springframework.beans.factory.annotation.Autowired;
import service.ArgsValidationService;
import service.LendingRequestBuilder;

/**
 *
 * @author andre
 */
public class Launcher {

    @Autowired
    private ArgsValidationService validationService;

    @Autowired
    private LendingRequestBuilder requestBuilder;

    public void run(String[] args) {
        validationService.validate(args);
        requestBuilder.build(args);
    }

}
