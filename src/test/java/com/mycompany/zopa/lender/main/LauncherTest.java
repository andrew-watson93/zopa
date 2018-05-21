/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.zopa.lender.main;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.eq;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import org.mockito.junit.MockitoJUnitRunner;
import service.ArgsValidationService;
import service.LendingRequestBuilder;

/**
 *
 * @author andre
 */
@RunWith(MockitoJUnitRunner.class)
public class LauncherTest {

    @Mock
    private ArgsValidationService service;

    @Mock
    private LendingRequestBuilder builder;

    @InjectMocks
    private Launcher launcher;

    @Test
    public void run_CallsArgValidator() {
        String[] args = new String[1];
        launcher.run(args);
        verify(service).validate(eq(args));
    }

    @Test
    public void run_CallsLendingRequestBuilder() {
        String[] args = new String[1];
        launcher.run(args);
        verify(builder).build(eq(args));
    }

}
