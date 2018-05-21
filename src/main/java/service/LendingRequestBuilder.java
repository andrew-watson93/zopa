/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.mycompany.zopa.lending.LendingRequest;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author andre
 */
public class LendingRequestBuilder {

    public LendingRequest build(String[] args) {
        validateLength(args);
        String filename = getFileName(args);
        Float amount = getAmount(args);
        return null;
    }

    private void validateLength(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Please provide 2 arguments - a filename and a amount to borrow");
        }
    }

    private String getFileName(String[] args) {
        String fileName = args[0];
        if (fileName == null || !fileName.endsWith(".csv")) {
            throw new IllegalArgumentException();
        }
        return fileName;
    }

    private Float getAmount(String[] args) {
        String amtString = args[1];
        if (amtString == null || !StringUtils.isNumeric(amtString)) {
            throw new IllegalArgumentException("Please provide a number for the second argument");
        }
//        Float amt = Float.parseFloat(amtString);
        return 1.0f;
    }

}
