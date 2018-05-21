/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.zopa.lender.main;

import service.ArgsValidationService;

/**
 *
 * @author andre
 */
public class Launcher {

    private final ArgsValidationService validationService;

    public Launcher(ArgsValidationService validationService) {
        this.validationService = validationService;
    }

    public void run(String[] args) {
        validationService.validate(args);
    }

}
