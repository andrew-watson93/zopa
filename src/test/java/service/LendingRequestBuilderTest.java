/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.mycompany.zopa.lending.Lender;
import com.mycompany.zopa.lending.LendingRequest;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
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
public class LendingRequestBuilderTest {

    @Mock
    private CSVParser csvParser;

    @InjectMocks
    private LendingRequestBuilder builder;

    @Test(expected = IllegalArgumentException.class)
    public void validate_ThrowsExceptionIfNumberOfArgsLessThan2() {
        String[] args = new String[1];
        builder.build(args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void build_ThrowsExceptionIfNumberOfArgsGreaterThan2() {
        String[] args = new String[3];
        builder.build(args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void build_ThrowsExceptionIfFirstArgNotFilename() {
        String[] args = new String[2];
        args[0] = "";
        builder.build(args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void build_ThrowsExceptionIfFirstArgNull() {
        String[] args = new String[2];
        builder.build(args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void build_ThrowsExceptionIfSecondArgNull() {
        String[] args = new String[2];
        args[0] = "test.csv";
        builder.build(args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void build_ThrowsExceptionIfSecondArgNotNumeric() {
        String[] args = new String[2];
        args[0] = "test.csv";
        args[1] = "not a number";
        builder.build(args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void build_ThrowsExceptionIfAmtNotMultipleOf100() {
        String[] args = new String[2];
        args[0] = "test.csv";
        args[1] = "101";
        builder.build(args);
    }

    @Test
    public void build_CallsCSVParserIfArgsValid() {
        String[] args = new String[2];
        args[0] = "test.csv";
        args[1] = "100";
        builder.build(args);
        verify(csvParser).parse(eq("test.csv"));
    }

    @Test
    public void build_ReturnsLendingRequestWithRequestedVals() {
        List<Lender> lenders = new ArrayList<>();
        when(csvParser.parse("test.csv")).thenReturn(lenders);
        String[] args = new String[2];
        args[0] = "test.csv";
        args[1] = "100";
        LendingRequest request = builder.build(args);
        assertThat(request.getAmount(), is(100.0f));
        assertThat(request.getLenders(), is(lenders));
    }

}
