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
public class Main {

    public static void main(String[] args) {
        ArgsValidationService validationService = new ArgsValidationService();
        new Launcher(validationService).run(args);
    }

}
