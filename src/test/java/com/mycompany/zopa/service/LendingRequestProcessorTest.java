/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.zopa.service;

import com.mycompany.zopa.lending.Lender;
import com.mycompany.zopa.lending.LendingRequest;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

/**
 *
 * @author andre
 */
@RunWith(MockitoJUnitRunner.class)
public class LendingRequestProcessorTest {

    @InjectMocks
    private LendingRequestProcessor processor;

    @Test
    public void process_ReturnsInsufficentFundsMessageIfNecesary() {
        Lender lender = new Lender("name", 7.0, 100.0);
        Double amount = 101.0;
        List<Lender> lenders = Arrays.asList(lender);
        LendingRequest request = new LendingRequest(amount, lenders);
        String message = processor.process(request);
        assertThat(message, is("Loan not available, insufficent funds"));
    }

}
