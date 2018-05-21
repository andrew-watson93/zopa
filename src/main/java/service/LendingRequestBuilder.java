/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.mycompany.zopa.lending.LendingRequest;

/**
 *
 * @author andre
 */
public class LendingRequestBuilder {

    public LendingRequest build(String[] args) {
        validateLength(args);
        String filename = getFileName(args);
        return null;
    }

    private void validateLength(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Please provide 2 arguments - a filename and a amount to borrow");
        }
    }

    private String getFileName(String[] args) {
        String file = args[0];
        if (!file.endsWith(".csv")) {
            throw new IllegalArgumentException();
        }
        return file;
    }

}
