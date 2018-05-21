/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.zopa.lender.main;

import com.mycompany.zopa.lending.LendingRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.eq;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;
import service.ArgsValidationService;
import service.LendingRequestBuilder;
import service.LendingRequestProcessor;

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

    @Mock
    private LendingRequestProcessor requestProcessor;

    @InjectMocks
    private Launcher launcher;

    private String[] args;
    private LendingRequest request;

    @Before
    public void setup() {
        args = new String[1];
        request = new LendingRequest();
        when(builder.build(args)).thenReturn(request);
        launcher.run(args);
    }

    @Test
    public void run_CallsArgValidator() {
        verify(service).validate(eq(args));
    }

    @Test
    public void run_CallsLendingRequestBuilder() {
        verify(builder).build(eq(args));
    }

    @Test
    public void run_PassesRequestToRequestProcessor() {
        verify(requestProcessor).process(eq(request));

    }

}
