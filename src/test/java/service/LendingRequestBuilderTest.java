/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import org.junit.Test;

/**
 *
 * @author andre
 */
public class LendingRequestBuilderTest {

    private LendingRequestBuilder builder = new LendingRequestBuilder();

    @Test(expected = IllegalArgumentException.class)
    public void validate_ThrowsExceptionIfNumberOfArgsLessThan2() {
        String[] args = new String[1];
        builder.build(args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void validate_ThrowsExceptionIfNumberOfArgsGreaterThan2() {
        String[] args = new String[3];
        builder.build(args);
    }

    @Test
    public void validate_OkIfNumberOfArgs2AndValid() {
        String[] args = new String[2];
        builder.build(args);
    }

}
