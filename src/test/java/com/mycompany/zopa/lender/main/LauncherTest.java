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
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.eq;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

/**
 *
 * @author andre
 */
@RunWith(MockitoJUnitRunner.class)
public class LauncherTest {

    @Mock
    private LendingRequestBuilder builder;

    @Mock
    private LendingRequestProcessor requestProcessor;

    @InjectMocks
    private Launcher launcher;

    private String[] args;
    private LendingRequest request;

    @Before
    public void setup() throws FileNotFoundException, IOException {
        args = new String[1];
        request = new LendingRequest();
        when(builder.build(args)).thenReturn(request);
        launcher.run(args);
    }

    @Test
    public void run_CallsLendingRequestBuilder() throws FileNotFoundException, IOException {
        verify(builder).build(eq(args));
    }

    @Test
    public void run_PassesRequestToRequestProcessor() {
        verify(requestProcessor).process(eq(request));

    }

}
