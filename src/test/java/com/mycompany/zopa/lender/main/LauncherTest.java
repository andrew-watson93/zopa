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

/**
 *
 * @author andre
 */
@RunWith(MockitoJUnitRunner.class)
public class LauncherTest {

    @Mock
    private ArgsValidationService service;

    @InjectMocks
    private Launcher launcher;

    @Test
    public void testRunCallsArgValidator() {
        String[] args = new String[1];
        launcher.run(args);
        verify(service).validate(eq(args));
    }

}
