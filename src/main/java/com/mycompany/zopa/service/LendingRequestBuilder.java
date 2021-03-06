/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.zopa.service;

import com.mycompany.zopa.lending.Lender;
import com.mycompany.zopa.lending.LendingRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author andre
 */
public class LendingRequestBuilder {

    private final CSVParser csvParser;
    private final Double MIN_LOAN = 1000.0;
    private final Double MAX_LOAN = 15000.0;

    public LendingRequestBuilder(CSVParser csvParser) {
        this.csvParser = csvParser;
    }

    public LendingRequest build(String[] args) throws FileNotFoundException, IOException {
        validateLength(args);
        String filename = getFileName(args);
        Double amount = getAmount(args);
        List<Lender> lenders = csvParser.parse(filename);
        return new LendingRequest(amount, lenders);
    }

    private void validateLength(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Please provide 2 arguments - a filename and a amount to borrow");
        }
    }

    private String getFileName(String[] args) {
        String fileName = args[0];
        if (fileName == null || !fileName.endsWith(".csv")) {
            throw new IllegalArgumentException("Please provide a valid csv file for the first argument");
        }
        return fileName;
    }

    private Double getAmount(String[] args) {
        String amtString = args[1];
        if (amtString == null || !StringUtils.isNumeric(amtString)) {
            throwAmountException();
        }
        Double amount = Double.parseDouble(amtString);
        if (amount % 100 != 0
                || amount < MIN_LOAN
                || amount > MAX_LOAN) {
            throwAmountException();
        }
        return amount;
    }

    private void throwAmountException() throws IllegalArgumentException {
        throw new IllegalArgumentException("Please provide a multiple of 100 between 1000 and 15000 for the second argument");
    }

}
